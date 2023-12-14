package com.agilelabs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.agilelabs.entity")
@EnableJpaRepositories(basePackages = "com.agilelabs")
public class AgilelabsApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgilelabsApplication.class, args);
    }
}
