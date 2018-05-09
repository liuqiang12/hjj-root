package com.scgxdz.base_serv.rabbitmq.config;

import com.scgxdz.base_serv.rabbitmq.exchange.RabbitmqExchange;
import com.scgxdz.base_serv.rabbitmq.queue.RabbitmqQueue;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 基本使用的为topic，
 * 此处更多是以案例给出
 */
@Configuration
public class ExchangeConfig {
    /**
     * 合同->匹配型 默认：, durable = true, autoDelete = false
     * queue是持久化的
     * @param rabbitAdmin
     * @return
     */
    @Bean
    TopicExchange contractTopicExchangeDurable(RabbitAdmin rabbitAdmin) {
        TopicExchange contractTopicExchange = new TopicExchange(RabbitmqExchange.EXCHANGE_TOPIC);
        rabbitAdmin.declareExchange(contractTopicExchange);
        return contractTopicExchange;
    }

    @Bean
    Binding bindingExchangeContract(Queue queueContract, TopicExchange exchange, RabbitAdmin rabbitAdmin) {
        Binding binding = BindingBuilder.bind(queueContract).to(exchange).with(RabbitmqQueue.QUEUE);
        rabbitAdmin.declareBinding(binding);
        return binding;
    }

    /**
     * 所有关于contract exchange的queue
     *
     * @param rabbitAdmin
     * @return
     */
    @Bean
    Queue queueContract(RabbitAdmin rabbitAdmin) {
        Queue queue = new Queue(RabbitmqQueue.QUEUE, true);
        rabbitAdmin.declareQueue(queue);
        return queue;
    }
}
