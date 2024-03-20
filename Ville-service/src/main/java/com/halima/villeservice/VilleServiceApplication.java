package com.halima.villeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VilleServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VilleServiceApplication.class, args);
    }

}
