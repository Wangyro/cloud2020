package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Wang Yuran
 * @create 2021-09-08 14:06
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Account2003 {
    public static void main(String[] args) {
        SpringApplication.run(Account2003.class,args);
    }
}
