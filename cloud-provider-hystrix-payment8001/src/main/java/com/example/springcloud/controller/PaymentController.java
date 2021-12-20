package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2021-08-26 14:05
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String PaymentInfo_Ok(@PathVariable("id") Integer id){
        return paymentService.PaymentInfo_Ok(id);

    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod ="paymentInfo_callback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),  //是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"), //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),  //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")   //失败率达到多少后跳闸

    } )
    public String PaymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentService.PaymentInfo_Timeout(id);
    }

    public String paymentInfo_callback(@PathVariable("id")Integer id){
        return "please retry,id :"+id;
    }
}
