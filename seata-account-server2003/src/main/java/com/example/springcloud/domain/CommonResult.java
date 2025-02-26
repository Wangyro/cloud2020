package com.example.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wang Yuran
 * @create 2021-09-08 16:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>  {
    private Integer code;

    private String message;

    private  T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
