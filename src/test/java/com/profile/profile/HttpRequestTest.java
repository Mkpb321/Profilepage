package com.profile.profile;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/api/profile/1",
                String.class)).contains("{\"id\":1,\"name\":\"Mike Burkhard\",\"image\":\"https://moonvillageassociation.org/wp-content/uploads/2018/06/default-profile-picture1.jpg\",\"description\":\"Ich arbeite zurzeit als Software Ingenieur im firmenübergreifenden Trainee-Programm der M&F Engineering AG (mehr Details unter m-f.ch/software-trainee-programm). Das Ziel dieses Programms ist es, junge motivierte Software Ingenieure wie mich und innovative Technologie-Firmen wie Sie zusammen zu bringen. Als Trainee habe ich die Möglichkeit, in 3 Jahren drei bis fünf Einsätze bei verschiedenen Partnerfirmen zu absolvieren und jeweils 6-12 Monate bei einer Partnerfirma im Software-Team vor Ort mitzuarbeiten.\",\"link\":\"https://www.m-f.ch/software-trainee-programm\"}");
    }
}
