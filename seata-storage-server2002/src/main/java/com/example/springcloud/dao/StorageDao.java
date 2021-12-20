package com.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:24
 */

@Mapper
public interface StorageDao {
    //扣减库存
    void decrease(@Param("productId")Long productId, @Param("count")Integer count);
}
