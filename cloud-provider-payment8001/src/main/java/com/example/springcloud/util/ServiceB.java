package com.example.springcloud.util;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2021-12-20 16:23
 */
@Component
public class ServiceB {
    @Resource
    private ServiceA serviceA;
    public void test(){
        System.out.println("======serviceB S进入test()方法");
    }
}
