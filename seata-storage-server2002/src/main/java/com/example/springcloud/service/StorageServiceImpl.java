package com.example.springcloud.service;

import com.example.springcloud.dao.StorageDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Wang Yuran
 * @create 2021-09-08 15:35
 */
@Service
public class StorageServiceImpl implements  StorageService{
    @Resource
    private StorageDao storageDao;
    private static final Logger LOGGER= LoggerFactory.getLogger(StorageServiceImpl.class);

    @Override
    public void decrease(Long productId, Integer count) {
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        storageDao.decrease(productId,count);
        LOGGER.info("扣减库存");
    }
}
