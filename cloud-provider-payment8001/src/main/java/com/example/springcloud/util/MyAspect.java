package com.example.springcloud.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author Wang Yuran
 * @create 2021-12-20 14:01
 */
@Aspect
@Component
public class MyAspect {
    @Before("execution(public int com.example.springcloud.service.PaymentServiceImpl.*(..))")
    public void beforeNotify(){
        System.out.println("=======@Before 是前置通知MyAspect");
    }
    @After("execution(public int com.example.springcloud.service.PaymentServiceImpl.*(..))")
    public void afterNotify(){
        System.out.println("=======@After 是后置通知MyAspect");
    }
    @AfterReturning("execution(public int com.example.springcloud.service.PaymentServiceImpl.*(..))")
    public void afterReturningNotify(){
        System.out.println("=======@AfterReturning 是返回后通知MyAspect");
    }
    @AfterThrowing("execution(public int com.example.springcloud.service.PaymentServiceImpl.*(..))")
    public void afterThrowingNotify(){
        System.out.println("=======@AfterThrowing 是异常通知MyAspect");
    }
    @Around("execution(public int com.example.springcloud.service.PaymentServiceImpl.*(..))")
    public  Object aroundNotify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object retValue=null;
        System.out.println("是环绕通知AAA");
        retValue=proceedingJoinPoint.proceed();
        System.out.println("是环绕通知BBB");
        return retValue;
    }
}
