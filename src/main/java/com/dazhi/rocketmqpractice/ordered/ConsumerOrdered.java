package com.dazhi.rocketmqpractice.ordered;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        topic = "orderedTest",
        consumerGroup = "ordered-consumer-fanout",
        selectorExpression = "tagA||tagB||tagC",
        messageModel = MessageModel.CLUSTERING  // 集群模式
)
public class ConsumerOrdered implements RocketMQListener<String> {
    @Override
    public void onMessage(String messageExt) {
        System.out.println(messageExt);
    }
}
