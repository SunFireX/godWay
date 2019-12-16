package com.dyt.swm.godway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.dyt.swm.godway")
public class GodwayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GodwayApplication.class, args);
    }

}
