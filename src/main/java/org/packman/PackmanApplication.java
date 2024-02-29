package org.packman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan(value = {"org.packman.config"})
public class PackmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PackmanApplication.class, args);
    }

}
