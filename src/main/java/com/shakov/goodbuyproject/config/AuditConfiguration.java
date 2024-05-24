package com.shakov.goodbuyproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class AuditConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
//        SecurityContext.getUser().getUsername();
        return () -> Optional.of("Shakov");
    }
}
