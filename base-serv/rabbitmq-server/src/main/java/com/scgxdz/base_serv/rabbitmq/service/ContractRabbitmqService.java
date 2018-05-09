package com.scgxdz.base_serv.rabbitmq.service;

import com.scgxdz.base_serv.rabbitmq.exchange.RabbitmqExchange;
import com.scgxdz.base_serv.rabbitmq.model.ContractRabbitmq;
import com.scgxdz.base_serv.rabbitmq.model.TenantRabbitmq;
import com.scgxdz.base_serv.rabbitmq.queue.RabbitmqQueue;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractRabbitmqService implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

@Autowired
    private RabbitMessagingTemplate rabbitMessagingTemplate;

    public void sendContractRabbitmqTopic(final ContractRabbitmq ContractRabbitmq) {
        this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.EXCHANGE_TOPIC, RabbitmqQueue.QUEUE, ContractRabbitmq);
    }

    public void sendContractRabbitmqDirect(final ContractRabbitmq ContractRabbitmq) {
        this.rabbitMessagingTemplate.convertAndSend(RabbitmqExchange.EXCHANGE_DIRECT, RabbitmqQueue.QUEUE, ContractRabbitmq);
    }
    /**
     * 回调函数不起作用，暂时没搞清楚
     */
    //消息发送确认回调方法
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            System.out.println("消息确认成功");
        } else {
            System.out.println("消息确认失败");
        }
    }
    //消息发送失败回调方法
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息发送失败:" + new String(message.getBody()));
    }
}
