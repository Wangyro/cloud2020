package com.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:50
 */
@Mapper
public interface AccountDao {
    void decrease(@Param("userId")Long userId, @Param("money")BigDecimal money);
}
