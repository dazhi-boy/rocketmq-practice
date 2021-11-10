package com.dazhi.rocketmqpractice.ordered;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("ordered")
public class ProducerOrdered {
    @Autowired
    RocketMQTemplate rocketMQTemplate;

    @GetMapping
    public SendResult send(String tag) throws Exception {
        String str = "this is ordered message";
        SendResult sendResult = rocketMQTemplate.syncSendOrderly("orderedTest:" + tag, str.getBytes(RemotingHelper.DEFAULT_CHARSET), tag);
        return sendResult;
    }
}
