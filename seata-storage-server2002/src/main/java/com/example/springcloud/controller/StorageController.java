package com.example.springcloud.controller;

import com.example.springcloud.domian.CommonResult;
import com.example.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:38
 */
@RestController
public class StorageController {
    @Resource
    private StorageService storageService;

    @GetMapping(value="/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count){
        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功");

    }
}
