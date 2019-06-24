package com.auch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerDemoApp {
    
    private static final Logger log = LoggerFactory.getLogger(CustomerDemoApp.class);

    public static void main(String[] args) {
        log.info("Start Application");
        SpringApplication.run(CustomerDemoApp.class, args);
    }
}