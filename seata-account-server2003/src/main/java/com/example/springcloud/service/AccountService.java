package com.example.springcloud.service;

import java.math.BigDecimal;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:54
 */
public interface AccountService {
    public void decrease(Long userId, BigDecimal money);
}
