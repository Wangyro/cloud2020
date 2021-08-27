package com.example.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wang Yuran
 * @create 2021-08-25 16:31
 */
@Configuration
public class PaymentLogConfiguration {

    @Bean
    Logger.Level feignLoggerLeve(){
        return Logger.Level.FULL;
    }
}
