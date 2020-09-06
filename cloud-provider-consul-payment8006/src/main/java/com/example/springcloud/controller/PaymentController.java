package com.example.springcloud.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Wang Yuran
 * @create 2020-08-20 23:28
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = "/payment/consul")
    public String paymentConsul(){
        return "springcloud with consul:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }

}
