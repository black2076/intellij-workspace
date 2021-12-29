package com.tmax.bjk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// @EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application { // extends SpringBootServletInitializer {
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ServletContextInitializer.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*public static void main(String[] args) {
        SpringApplication.run(ServletContextInitializer.class, args);
    }*/
}
