package com.dazhi.rocketmqpractice.simple;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("simple")
public class ProducerSimple {
    private static Logger log = LoggerFactory.getLogger(ProducerSimple.class);
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    // 同步消息
    @GetMapping("sync")
    public SendResult sync() {
        String str = "this is sync message";
        SendResult sendResult = rocketMQTemplate.syncSend("synsTest", str);
        return sendResult;
    }

    // 异步消息
    @GetMapping("async")
    public String Async() {
        String str = "this is async message";
        rocketMQTemplate.asyncSend("asyncTest", str, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.warn("success", sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                log.warn("exception", throwable);
            }
        });
        log.warn(str);
        return str;
    }

    // 单向消息（有来无回）
    @GetMapping("oneway")
    public String oneway() {
        String str = "this is oneway message";
        rocketMQTemplate.sendOneWay("onewayTest", str);
        return str;
    }
}
