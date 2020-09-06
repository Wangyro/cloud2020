package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Wang Yuran
 * @create 2020-08-26 16:35
 */
public interface LoadBlancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
