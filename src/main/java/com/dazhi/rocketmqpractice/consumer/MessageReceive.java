package com.dazhi.rocketmqpractice.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = "TopicTest",
        consumerGroup = "demo-consumer-fanout",
        messageModel = MessageModel.CLUSTERING
)
public class MessageReceive implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        System.out.println("fanout:" + s);
    }
}
