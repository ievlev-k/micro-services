package ru.itmo.userserver.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import ru.itmo.userserver.model.Role;
import ru.itmo.userserver.model.User;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Service;
import ru.itmo.userserver.service.JWTService;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Override
    public User getUserDetails(String token) {
        System.out.println("secretKey: " + secretKey);
        if (Objects.isNull(token) || !Jwts.parserBuilder().build().isSigned(token)) {
            throw new AuthenticationServiceException("Signed id_token required.");
        }
        var claims = getClaims(token);

        if (claims.getExpiration().before(Date.from(Instant.now()))) {
            throw new ExpiredJwtException(Jwts.header(), claims, "Token is expired");
        }

        var userRole = (String) claims.get("role");
        var userId   = (String) claims.get("id");
        return User.builder()
                .id(UUID.fromString(userId))
                .role(Role.valueOf(userRole))
                .build();
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
