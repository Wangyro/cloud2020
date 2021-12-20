package com.example.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Wang Yuran
 * @create 2021-09-08 14:36
 */
@Configuration
@MapperScan({"com.example.springcloud.dao"})
public class MybatisConfig {
}
