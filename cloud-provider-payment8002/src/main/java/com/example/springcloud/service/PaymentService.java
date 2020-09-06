package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wang Yuran
 * @create 2020-08-18 20:21
 */
public interface PaymentService
{
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}

