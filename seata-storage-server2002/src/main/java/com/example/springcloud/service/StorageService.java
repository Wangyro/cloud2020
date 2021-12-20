package com.example.springcloud.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:35
 */
public interface StorageService {

    public void decrease(Long productId,Integer count);
}
