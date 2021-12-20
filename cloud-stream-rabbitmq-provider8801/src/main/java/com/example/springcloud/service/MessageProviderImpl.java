package com.example.springcloud.service;

import org.bouncycastle.i18n.MessageBundle;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author Wang Yuran
 * @create 2021-09-02 9:50
 */
@EnableBinding(Source.class)   //定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider{
    @Resource
    private MessageChannel output;
    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*****serial: "+serial);
        return serial;
    }
}
