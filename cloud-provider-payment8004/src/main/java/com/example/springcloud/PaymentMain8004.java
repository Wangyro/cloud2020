package com.example.springcloud;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Wang Yuran
 * @create 2020-08-17 23:47
 */
@SpringBootApplication
@EnableDiscoveryClient  //该注解用于向使用consul和zooleeper作为注册中心注册服务
public class PaymentMain8004
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }
}