package com.scgxdz.base_serv.rabbitmq.service;

import com.google.gson.Gson;
import com.scgxdz.base_serv.rabbitmq.model.ContractRabbitmq;
import com.scgxdz.base_serv.rabbitmq.model.TenantRabbitmq;
import com.scgxdz.base_serv.rabbitmq.queue.RabbitmqQueue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverService {

    @RabbitListener(queues = RabbitmqQueue.CONTRACE_SELF)
    public void receiveContractQueue(ContractRabbitmq contract) {
        System.out.println("Received contract<" + new Gson().toJson(contract) + ">");
    }

    @RabbitListener(queues = RabbitmqQueue.CONTRACE_TENANT)
    public void receiveTenantQueue(TenantRabbitmq tenant) {
        System.out.println("Received Bar<" + new Gson().toJson(tenant) + ">");
    }
}
