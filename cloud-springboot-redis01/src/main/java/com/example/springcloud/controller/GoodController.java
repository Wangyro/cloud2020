package com.example.springcloud.controller;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Yuran
 * @create 2022-01-04 22:48
 */
@RestController
public class GoodController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/buy_goods")
    public String buyGoods(){
        synchronized (this) {
            String result = redisTemplate.opsForValue().get("goods:001");
            int goodsNumber = result == null ? 0 : Integer.parseInt(result);
            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;
                redisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));
                System.out.println("成功买到商品，库存还剩下：" + realNumber + "件" + "\t+服务提供端口：" + serverPort);
                return "成功买到商品，库存还剩下：" + realNumber + "件" + "\t+服务提供端口：" + serverPort;
            } else {
                System.out.println("商品已经售完/活动结束等" + "\t+服务提供端口：" + serverPort);
            }
            return "商品已经售完/活动结束等" + "\t+服务提供端口：" + serverPort;

        }
    }
}
