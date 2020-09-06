package com.example.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Wang Yuran
 * @create 2020-08-18 13:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private  T data;
    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
