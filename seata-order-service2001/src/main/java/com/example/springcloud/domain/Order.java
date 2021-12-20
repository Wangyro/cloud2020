package com.example.springcloud.domain;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author Wang Yuran
 * @create 2021-09-08 10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    //订单状态:  0:创建中 1:已完结
    private Integer status;
}
