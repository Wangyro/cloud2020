package com.example.springcloud.service.impl;

import com.example.springcloud.dao.OrderDao;
import com.example.springcloud.domain.Order;
import com.example.springcloud.service.AccountService;
import com.example.springcloud.service.OrderService;
import com.example.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2021-09-08 10:50
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name="fsp-create-order",rollbackFor=Exception.class)   //事务的发起方TM
    public void create(Order order) {
        log.info("-------> 创建订单 <--------");
        orderDao.create(order);
        log.info("-------> 订单微服务开始调用库存微服务做减库存操作start");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("-------> 订单微服务开始调用库存微服务做减库存操作end");

        log.info("-------> 订单微服务开始调用账户微服务做扣余额存操作start");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("-------> 订单微服务开始调用账户微服务做扣余额存操作end");
        log.info("-------> 修改订单状态start");
        orderDao.update(order.getUserId(),0);
        log.info("-------> 修改订单状态end");
    }


}
