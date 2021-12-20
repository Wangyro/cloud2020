package com.example.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * @author Wang Yuran
 * @create 2021-08-30 15:33
 */
@SpringBootApplication

@EnableEurekaClient
public class Gateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(Gateway9527.class,args);
    }

   /* @Value("${test.uri}")
    private String uri;

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //basic proxy
                .route(r -> r.path("/order/**")
                        .uri(uri)
                ).build();
    }*/

}
