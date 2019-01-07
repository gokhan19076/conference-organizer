package com.cinibulak.conferenceorganizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class ConferenceOrganizerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConferenceOrganizerApplication.class, args);
    }

}
