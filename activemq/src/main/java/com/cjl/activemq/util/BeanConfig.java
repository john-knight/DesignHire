package com.cjl.activemq.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.apache.activemq.command.ActiveMQQueue;
import javax.jms.Queue;

@Configuration
public class BeanConfig {

    // 定义存放消息的队列
    @Bean
    public Queue queue() {
       return  new ActiveMQQueue("ActiveMQQueue");
    }
}
