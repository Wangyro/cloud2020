package com.example.springcloud.service;

import com.example.springcloud.dao.AccountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:54
 */
@Service
public class AccountServiceImpl implements AccountService{
    @Resource
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        accountDao.decrease(userId,money);

    }
}
