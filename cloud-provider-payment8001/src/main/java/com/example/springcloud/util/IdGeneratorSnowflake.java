package com.example.springcloud.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author Wang Yuran
 * @create 2021-09-13 17:29
 */
@Component
@Slf4j
public class IdGeneratorSnowflake {

    private long workerId=0;
    private long dataCenterId=1;
    private Snowflake snowflake= IdUtil.getSnowflake(workerId,dataCenterId);
    @PostConstruct
    public void init(){
        try {

            workerId= NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
            log.info("当前机器的Id :{}"+workerId);
        }catch (Exception e){
            e.printStackTrace();
            log.warn("机器Id获取失败}："+e);
            workerId=NetUtil.getLocalhost().hashCode();
        }

    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(long workerId,long dataCenterId){
        return snowflake.nextId();
    }
}
