package com.example.springcloud.service;

import com.example.springcloud.util.ServiceA;
import com.example.springcloud.util.ServiceB;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Wang Yuran
 * @create 2021-12-20 14:14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class PaymentServiceImplTest {
    @Resource
    private  PaymentService paymentService;
    @Resource
    private ServiceA serviceA;
    @Resource
    private ServiceB serviceB;

    @Test
    void div() {
        //输出springboot的版本
        System.out.println("spring版本："+ SpringVersion.getVersion()+"\t"+"springboot版本"+ SpringBootVersion.getVersion());
        paymentService.div(10,2);
    }
    @Test
    void setterTest(){
        serviceA.test();
    }
}