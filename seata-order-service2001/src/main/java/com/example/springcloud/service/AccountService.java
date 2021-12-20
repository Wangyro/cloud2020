package com.example.springcloud.service;

import com.example.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author Wang Yuran
 * @create 2021-09-08 11:12
 */
@FeignClient(value = "seata-server-account")
public interface AccountService {

    @RequestMapping(value="/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
