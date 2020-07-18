package edu.sharif.ce.ap.sbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class SbTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbTestApplication.class, args);
    }

}
