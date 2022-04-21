package com.dsuser22.regionsdirectory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RegionsDirectoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegionsDirectoryApplication.class, args);
    }

}
