package com.scgxdz.base_serv.rabbitmq.callback;

import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;

import lombok.extern.slf4j.Slf4j;

/**
 * 确认消息是否成功发送给交换机
 */
@Slf4j
public class MsgSendConfirmCallBack implements ConfirmCallback {

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info(" 回调消息id:" + correlationData);
        if (ack) {
            log.info("消息发送确认成功");
        } else {
            log.info("消息发送确认失败:" + cause+"\n重新发送");

        }
    }
}
