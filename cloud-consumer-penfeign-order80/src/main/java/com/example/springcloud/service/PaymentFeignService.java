package com.example.springcloud.service;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Wang Yuran
 * @create 2021-08-25 15:30
 */
@Component
@FeignClient(value ="CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);

}
