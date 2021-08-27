package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Wang Yuran
 * @create 2021-08-25 15:18
 */
@SpringBootApplication
@EnableFeignClients
public class OpenFeignOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignOrder80.class, args);
    }
}
