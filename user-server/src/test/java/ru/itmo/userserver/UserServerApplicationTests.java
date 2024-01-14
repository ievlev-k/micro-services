package ru.itmo.userserver;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
;import ru.itmo.userserver.init.Postgres;



@SpringBootTest(classes = UserServerApplication.class)
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
@ActiveProfiles("test")
@Transactional
public class UserServerApplicationTests {


    @BeforeAll
    static void init(){
        Postgres.container.start();
    }

    @Test
    void contextLoads() {
    }

}
