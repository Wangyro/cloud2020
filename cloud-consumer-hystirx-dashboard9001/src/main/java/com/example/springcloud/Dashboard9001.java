package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Wang Yuran
 * @create 2021-08-30 10:54
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Dashboard9001 {
    public static void main(String[] args) {
        SpringApplication.run(Dashboard9001.class,args);
    }
}
