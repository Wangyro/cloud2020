package com.example.springcloud.controller;

import com.example.springcloud.util.RedisUtil;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Wang Yuran
 * @create 2022-01-04 22:48
 */
@RestController
public class GoodController {
    public static final String REDIS_LOCK = "atguiguLock";
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private Redisson redisson;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/buy_goods")
    public String buyGoods() throws Exception {
        RLock lock = redisson.getLock(REDIS_LOCK);
        String value = UUID.randomUUID().toString() + Thread.currentThread().getName();
        try {
           /* Boolean flag = redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK, value);  //添加redis分布式锁
            redisTemplate.expire(REDIS_LOCK,10L, TimeUnit.SECONDS);  //给锁加过期时间*/
           /*Boolean flag=redisTemplate.opsForValue().setIfAbsent(REDIS_LOCK,value,10L,TimeUnit.SECONDS);  //成为原子性操作
            if (!flag) {
                return "抢锁失败";

            }*/
           lock.lock();

            String result = redisTemplate.opsForValue().get("goods:001");

            int goodsNumber = result == null ? 0 : Integer.parseInt(result);

            if (goodsNumber > 0) {
                int realNumber = goodsNumber - 1;

                redisTemplate.opsForValue().set("goods:001", String.valueOf(realNumber));

                System.out.println("成功买到商品，库存还剩下：" + realNumber + "件" + "\t+服务提供端口：" + serverPort);

                return "成功买到商品，库存还剩下：" + realNumber + "件" + "\t+服务提供端口：" + serverPort;
            } else {
                System.out.println("商品已经售完/活动结束等" + "\t+服务提供端口：" + serverPort);
            }
            return "商品已经售完/活动结束等" + "\t+服务提供端口：" + serverPort;
        } finally {
            if(lock.isLocked()){
                if(lock.isHeldByCurrentThread()){
                    lock.unlock();
                }
            }

            /*//判断枷锁和解锁有可能不是同一个客户端
            if(redisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)) {   //只删除自己的锁，不允许删除其他的线程的锁
                //若在此时，这把锁突然不是这个客户端的，则会误解锁
                redisTemplate.delete(REDIS_LOCK); //redis 解锁
            }*/
            /*while(true){
                redisTemplate.watch(REDIS_LOCK);
                if(redisTemplate.opsForValue().get(REDIS_LOCK).equalsIgnoreCase(value)) {   //只删除自己的锁，不允许删除其他的线程的锁
                    redisTemplate.setEnableTransactionSupport(true);
                    redisTemplate.multi();
                    redisTemplate.delete(REDIS_LOCK);
                    List<Object> list=redisTemplate.exec();
                    if(list==null){
                        continue;
                    }
                    redisTemplate.unwatch();
                    break;
                }
            }*/
            /*Jedis jedis= RedisUtil.getJedis();
            String script="if redis.call('get',KEYS[1])==ARGV[1]"+
                    "then" +
                    "return redis.call('del',KEYS[1])" +
                    "else" +
                    "  return 0" +
                    "end";
            try {
                Object eval = jedis.eval(script, Collections.singletonList(REDIS_LOCK), Collections.singletonList(value));
                if("1".equals(eval.toString())){
                    System.out.println("=========del redis lock ok");
                }else{
                    System.out.println("=======del redis lock error");
                }
            }finally {
                if(null !=jedis){
                    jedis.close();
                }
            }*/

        }

    }
}
