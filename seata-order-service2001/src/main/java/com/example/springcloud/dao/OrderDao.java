package com.example.springcloud.dao;

import com.example.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wang Yuran
 * @create 2021-09-08 10:49
 */
@Mapper
public interface OrderDao {

    //创建订单
    void create(Order order);

    //修改订单
    void update(@Param("userId") Long userId,@Param("status")Integer status);
}
