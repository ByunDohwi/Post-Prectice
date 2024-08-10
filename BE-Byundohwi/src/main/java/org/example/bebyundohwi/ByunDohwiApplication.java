package org.example.bebyundohwi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ByunDohwiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ByunDohwiApplication.class, args);
    }

}
