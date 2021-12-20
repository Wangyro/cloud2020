package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wang Yuran
 * @create 2021-09-03 10:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Consumer83 {
    public static void main(String[] args) {
        SpringApplication.run(Consumer83.class,args);
    }
}
