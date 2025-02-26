package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wang Yuran
 * @create 2020-08-26 16:36
 */
@Component
public class MyLB implements LoadBlancer {
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{   //自旋锁
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE  ?  0 : current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));
            System.out.println("*******next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
