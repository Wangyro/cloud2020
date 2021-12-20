package com.example.springcloud.service;

import com.example.springcloud.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

/**
 * @author Wang Yuran
 * @create 2021-09-08 10:51
 */

public interface OrderService {

    public void create(Order order);


}
