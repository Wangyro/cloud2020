package com.example.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Wang Yuran
 * @create 2021-08-26 10:49
 */
@Service
public class PaymentService {

    public String PaymentInfo_Ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"  paymentInfo_Ok id:  "+id+"\t"+"~~";
    }
    @HystrixCommand(fallbackMethod ="PaymentInfo_callback",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    } )
    public String PaymentInfo_Timeout(Integer id){
        int timeNumber=5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池"+Thread.currentThread().getName()+"  paymentInfo_TimeOut id:  "+id+"\t"+"  耗时 :"+timeNumber;
    }

    public String PaymentInfo_callback(Integer id){
        return "线程池"+Thread.currentThread().getName()+"  paymentInfo_timeout id:  "+id+"\t"+"~call back~";
    }

}
