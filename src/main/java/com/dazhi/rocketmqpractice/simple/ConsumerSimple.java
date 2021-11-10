package com.dazhi.rocketmqpractice.simple;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
    topic = "synsTest",
    consumerGroup = "simple-consumer-fanout",
    messageModel = MessageModel.CLUSTERING  // 集群模式
)
public class ConsumerSimple implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        System.out.println(messageExt);
    }
}
