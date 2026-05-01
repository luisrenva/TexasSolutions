package com.example.texassolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.actuate.info.InfoContributor;
import  java.util.*;

@SpringBootApplication
public class TexasSolutionsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TexasSolutionsApplication.class, args);
    }

    @Bean
    public InfoContributor infoContributor() {
        return builder -> {
            Map<String, String> info = new HashMap<>();
            info.put("app-name", "Texas Solutions");
            info.put("version", "1.0.0");
            info.put("environment", "dev");
            builder.withDetail("app-info", info);
        };
    }

}
