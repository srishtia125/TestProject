package com.digital.and.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Srishti Agrawal
 */
@SpringBootApplication(scanBasePackages = {"com.digital"})
public class ApplicationServer {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationServer.class, args);
    }
}
