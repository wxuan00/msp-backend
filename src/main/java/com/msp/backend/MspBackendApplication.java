package com.msp.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.msp.backend")
@EntityScan(basePackages = "com.msp.backend.entity")
@EnableJpaRepositories(basePackages = "com.msp.backend.repository")
public class MspBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(MspBackendApplication.class, args);
    }
}
