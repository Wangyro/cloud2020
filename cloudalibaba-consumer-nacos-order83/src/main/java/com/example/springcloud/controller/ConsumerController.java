package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2021-09-03 10:23
 */
@RestController
public class ConsumerController {
    @Value("${service-url.nacos-user-service}")
    private String severURL;
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/echo/{string}")
    public String paymentInfo(@PathVariable String string){
        return restTemplate.getForObject(severURL+"/echo/"+string,String.class);

    }

}
