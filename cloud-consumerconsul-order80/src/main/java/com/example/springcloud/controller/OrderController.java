package com.example.springcloud.controller;


import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author Wang Yuran
 * @create 2020-08-18 22:37
 */
@RestController
@Slf4j
public class OrderController {
    //public static  final String PAYMENT_URL="http://localhost:8006";
   public static  final String PAYMENT_URL="http://consul-provider-payment";


    /**
     * RestTemplated提供了多种便捷的访问远程的Http服务的方法
     * 是一种简单便捷的访问restful服务模板类，是spring 提供用于访问Rest的客户端模板工具类
     */
    @Autowired
    private RestTemplate restTemplate;
    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/consumer/payment/consul")
    public String getPaymentcl(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }


}
