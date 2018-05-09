package com.scgxdz.base_serv.rabbitmq.service;

import com.google.gson.Gson;
import com.scgxdz.base_serv.rabbitmq.model.ContractRabbitmq;
import com.scgxdz.base_serv.rabbitmq.model.TenantRabbitmq;
import com.scgxdz.base_serv.rabbitmq.queue.RabbitmqQueue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverService {

    @RabbitListener(queues = RabbitmqQueue.QUEUE)
    public void receiveContractQueue(ContractRabbitmq contract) {
        System.out.println("Received QUEUE<" + new Gson().toJson(contract) + ">");
    }
}
