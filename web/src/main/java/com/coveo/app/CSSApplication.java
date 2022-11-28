package com.coveo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.coveo.*"})
@EntityScan(basePackages = {"com.coveo.*"})
@EnableJpaRepositories(basePackages = {"com.coveo.*"})

public class CSSApplication {
    public static void main(String[] args) {
            SpringApplication.run(CSSApplication.class);
    }

}
