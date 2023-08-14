package com.example.spingboott1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AuthorizationServiceApplicationTests {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Container
    private final GenericContainer<?> appOne = new GenericContainer<>("myapp:devapp_1.0")
            .withExposedPorts(8080);
    @Container
    private final GenericContainer<?> appTwo = new GenericContainer<>("myapp:prodapp_1.0")
            .withExposedPorts(8081);

    @Test
    void testContainerAppVersionFirst() {

        ResponseEntity<String> appEntity = testRestTemplate.getForEntity("http://localhost:" + appOne.getFirstMappedPort() + "/profile", String.class);
        Assertions.assertEquals("Current profile is dev", appEntity.getBody());
    }

    @Test
    void testContainerAppVersionTwo() {


        ResponseEntity<String> appEntity = testRestTemplate.getForEntity("http://localhost:" + appTwo.getFirstMappedPort() + "/profile", String.class);
        Assertions.assertEquals("Hello - version 2.0", appEntity.getBody());
    }
}