package ru.itmo.userserver.service.impl;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;
import ru.itmo.userserver.dto.request.LoginRequest;
import ru.itmo.userserver.model.JWTToken;
import ru.itmo.userserver.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Value;
import ru.itmo.userserver.service.UserService;

import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import static io.jsonwebtoken.SignatureAlgorithm.HS512;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private Integer lifeTime;

    private final UserService userService;

    public AuthorizationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public JWTToken createJWTToken(LoginRequest user) {
        System.out.println("secretKey: " + secretKey);
        var byLogin = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        var dateTime = LocalDateTime.now();
        var issuedDateInstant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        var expirationDateInstant = dateTime.plusHours(lifeTime).atZone(ZoneId.systemDefault()).toInstant();


        var customClaims = new HashMap<String, Object>();
        customClaims.put("role", byLogin.getRole().getAuthority());
        customClaims.put("id", byLogin.getId());

        var key = new SecretKeySpec(secretKey.getBytes(), HS512.getJcaName());

        var jwtBuilder = Jwts.builder()
                .addClaims(customClaims)
                .setIssuedAt(Date.from(issuedDateInstant))
                .setExpiration(Date.from(expirationDateInstant))
                .signWith(key, HS512);

        return JWTToken.builder()
                .value(jwtBuilder.compact())
                .build();
    }
}
