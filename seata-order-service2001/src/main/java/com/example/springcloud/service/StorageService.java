package com.example.springcloud.service;

import com.example.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wang Yuran
 * @create 2021-09-08 11:13
 */
@FeignClient(value = "seata-server-storage")
public interface StorageService {

    @RequestMapping(value="/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
