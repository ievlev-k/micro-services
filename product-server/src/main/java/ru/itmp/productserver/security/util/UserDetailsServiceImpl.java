package ru.itmp.productserver.security.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmp.productserver.feign.AuthFeignClient;
import ru.itmp.productserver.model.User;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;

@Service
@RequiredArgsConstructor
@Profile("!test")
public class UserDetailsServiceImpl implements UserDetailsService {

//    private final UserRepository userRepository;

    private AuthFeignClient authFeignClient;

    private CircuitBreaker circuitBreaker;
    @Autowired
    public UserDetailsServiceImpl(AuthFeignClient authFeignClient, CircuitBreaker circuitBreaker) {
        this.authFeignClient = authFeignClient;
        this.circuitBreaker = circuitBreaker;
    }

    //    private CircuitBreaker circuitBreaker;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user =circuitBreaker.decorateSupplier(() -> authFeignClient.findByUsername(username)).get();
        return  UserDetailsImpl.build(user);

    }
}