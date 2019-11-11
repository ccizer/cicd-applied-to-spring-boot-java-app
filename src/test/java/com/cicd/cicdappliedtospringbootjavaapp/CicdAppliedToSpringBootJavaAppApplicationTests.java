package com.cicd.cicdappliedtospringbootjavaapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CicdAppliedToSpringBootJavaAppApplicationTests {

    @LocalServerPort
    int port;

    final TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    void testSayHello() {
        final String url = String.format("http://localhost:%s", port);
        final HttpHeaders httpHeaders = new HttpHeaders();

        final ResponseEntity<String> response = testRestTemplate
                .exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders), String.class);

        assertThat("Hello from Spring Boot WEB!", is(equalTo(response.getBody())));
    }

    @Test
    void testMainClass() {
        CicdAppliedToSpringBootJavaAppApplication.main(new String[] {});
    }

}
