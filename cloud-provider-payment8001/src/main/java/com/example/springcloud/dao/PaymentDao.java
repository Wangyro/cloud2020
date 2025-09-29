package com.example.springcloud.dao;

import com.example.springcloud.entities.Payment;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wang Yuran
 * @create 2020-08-18 13:21
 */
@Mapper
public interface PaymentDao
{
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public int updateImagePath(@Param("id") Long id, @Param("imagePath") String imagePath);
}
