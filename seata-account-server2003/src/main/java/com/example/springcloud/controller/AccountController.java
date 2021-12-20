package com.example.springcloud.controller;


import com.example.springcloud.domain.CommonResult;
import com.example.springcloud.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:56
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;
    @GetMapping(value="/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money){
        accountService.decrease(userId,money);
        return new CommonResult(200,"减少账户余额成功");
    }
}
