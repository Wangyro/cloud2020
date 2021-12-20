package com.exmaple.springcloud;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Wang Yuran
 * @create 2021-09-16 13:52
 * 单例模式 双重锁校验，volatile禁止指令重排
 */
public class SingletionDemo {
    /*private static volatile  SingletionDemo instance=null;
    public SingletionDemo() {
        System.out.println(Thread.currentThread().getName()+"构造方法SingletonDemo");
    }
    public static SingletionDemo getInstance(){
        if(instance==null) {
            synchronized (SingletionDemo.class){
                if(instance==null) {
                    instance = new SingletionDemo();
                }
            }

        }
        return instance;
    }*/
    public List<String> findword(char[][] board, String[] words){
        List<String> strs=new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            int j=0;

            while(j<words[i].length()){
                int m=board.length-1;
                int n=0;
                while(m>0){
                    while(n<board[m].length){
                        if(board[m][n]==words[i].charAt(j)){
                            n++;
                            if(j>=words[i].length()-1){
                                break;
                            }else{
                                j++;
                            }
                            if(j==words[i].length()-1){
                                strs.add(words[i]);
                            }
                            continue;

                        }
                        break;
                    }
                    if(j>=words[i].length()-1){
                        break;
                    }else{
                        j++;
                    }
                    m--;

                }
            }

        }
        return strs;

    }


    public static void main(String[] args) {
        /*for(int i=0;i<10;i++){
            new Thread(()->{
                SingletionDemo.getInstance();
            },String.valueOf(i)).start();
        }
        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 2021)+"\t current data:"+atomicInteger.get());
*/
        char[][] board= {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        SingletionDemo demo=new SingletionDemo();
        List<String> strs=demo.findword(board,words);
        for (String item:strs) {
            System.out.println(item);

        }
    }
}
