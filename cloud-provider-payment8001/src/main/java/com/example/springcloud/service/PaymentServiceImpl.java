package com.example.springcloud.service;


import com.example.springcloud.dao.PaymentDao;
import com.example.springcloud.entities.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2020-08-18 20:48
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public int div(int x, int y) {
        int result=x/y;
        System.out.println("    ==========PaymentServiceImpl被调用了，计算结果是："+result);
        return result;
    }

    @Override
    public int updateImagePath(Long id, String imagePath) {
        return paymentDao.updateImagePath(id, imagePath);
    }
}
