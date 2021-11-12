package com.dazhi.rocketmqpractice.prducer;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rocket")
public class SendMessageController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping
    public String sendSimpleMessage() {
        for (int i = 0;i<10;i++) {
            rocketMQTemplate.convertAndSend("TopicTest", "这是一条测试信息" + i);
        }
        return "SUCCESS";
    }
}
