package com.cicd.cicdappliedtospringbootjavaapp.controller;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class HelloControllerTest {

    private HelloController helloController = new HelloController();

    @Test
    void testHelloController() {
        assertThat("Hello from Spring Boot!", is(equalTo(helloController.sayHello())));
    }
}
