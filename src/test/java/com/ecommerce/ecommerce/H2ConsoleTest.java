package com.ecommerce.ecommerce;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class H2ConsoleTest {

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() throws Exception {
        System.out.println("Application started on port: " + port);
        Thread.sleep(100000); // keep the application running to access H2 console
    }
}