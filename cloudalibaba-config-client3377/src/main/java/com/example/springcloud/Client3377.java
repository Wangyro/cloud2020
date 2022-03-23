package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wang Yuran
 * @create 2021-09-03 14:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Client3377 {
    public static void main(String[] args) {
        SpringApplication.run(Client3377.class,args);
    }
}
