package com.example.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Yuran
 * @create 2021-09-06 15:53
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "***** testA ******";
    }
    @GetMapping("/testB")
    public String testB(){
        return "***** testB ******";
    }

}
