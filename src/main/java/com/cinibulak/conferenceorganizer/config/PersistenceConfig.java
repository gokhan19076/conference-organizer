package com.cinibulak.conferenceorganizer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.cinibulak.conferenceorganizer.repository"})
@Configuration
public class PersistenceConfig{

}
