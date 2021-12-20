package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wang Yuran
 * @create 2021-09-02 17:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Provider9001 {
    public static void main(String[] args) {
        SpringApplication.run(Provider9001.class,args);
    }
}

