package com.exmaple.springcloud;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wang Yuran
 * @create 2021-09-15 15:25
 */

/**
 * volatile可见性
 * volatile增加了主内存与工作内存之间的可见性
 * volatile不能保证其原子性
 *  原子性指的是不可分割、完整性。在某个线程执行任务时，中间不可以被加塞、需要整体完整
 *  要么成功，要么失败
 *
 */
class Mydata{
    AtomicInteger number=new AtomicInteger(0);

    /*public void addTo60(){
        this.number=60;
    }*/
    public void addPlusPlus(){
        number.getAndIncrement();
    }
}
public class VolatileDemo {
    public static void main(String[] args) {
        Mydata myData=new Mydata();
        for(int i=0;i<20;i++){
            new Thread(()->{

                for(int j=1;j<=1000;j++) {
                    myData.addPlusPlus();
                }

            },String.valueOf(i)).start();
        }
        while(Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(myData.number);

    }

    /*private static void seekOkByVolatitle() {
        System.out.println("1111");
        Mydata myData=new Mydata();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(myData.number);
        },"AAA").start();
        while(myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"task is over"+myData.number);

    }*/
}
