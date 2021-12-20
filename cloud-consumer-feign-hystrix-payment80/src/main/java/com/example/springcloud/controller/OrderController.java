package com.example.springcloud.controller;

import com.example.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2021-08-27 10:50
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        return orderService.paymentInfo_Ok(id);

    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return orderService.paymentInfo_Timout(id);

    }
   /* public String paymentInfo_callback(@PathVariable("id")Integer id){
        return "please retry,id :"+id;
    }*/

}
