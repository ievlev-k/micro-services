package ru.itmo.userserver;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.userserver.init.Postgres;


@ActiveProfiles("test")
@SpringBootTest
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
@PropertySource("/application-test.properties")
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
