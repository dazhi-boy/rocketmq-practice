package com.dazhi.rocketmqpractice.prducer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RocketMqTest {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendSimpleMessage() {
        rocketMQTemplate.convertAndSend("TopicTest","这是一条测试信息");
    }
}
