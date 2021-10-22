package com.dazhi.rocketmqpractice.consumer;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = "TopicTest",
        consumerGroup = "demo-consumer-fanout",
        messageModel = MessageModel.BROADCASTING
)
public class MessageReceive {
}
