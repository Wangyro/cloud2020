package com.example.springcloud.controller;

import com.example.springcloud.entities.CommonResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Wang Yuran
 * @create 2020-08-18 20:26
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("***插入结果："+result);
        if(result>0){
            return  new CommonResult(200,"数据库插入成功 port:"+serverPort,result);
        }else{
            return new CommonResult(444,"主干添加，插入数据库失败 port:"+serverPort,null);
        }
    }
    @GetMapping(value ="/payment/get/{id}")
    public CommonResult getPaymentByID( @PathVariable("id") Long id){
        Payment result=paymentService.getPaymentById(id);
        log.info("***查询结果："+result);
        if(result!=null){
            return  new CommonResult(200,"查询成功 port:"+serverPort,result);
        }else{
            return new CommonResult(444,"查询失败，没有对应的记录，查询ID:"+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String item:services) {
            log.info("*****element:*****"+item);

        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances) {
            log.info(instance.getHost()+"\t"+instance.getServiceId()+"\t"+instance.getPort()+"\t"+instance.getUri() );

        }
        return discoveryClient;
    }
    @GetMapping(value = "/payment/zk")
    public String getPaymentzk(){
        return serverPort;
    }
}
