package com.scgxdz.base_serv.rabbitmq.controller;

import com.scgxdz.base_serv.rabbitmq.model.ContractRabbitmq;
import com.scgxdz.base_serv.rabbitmq.model.TenantRabbitmq;
import com.scgxdz.base_serv.rabbitmq.service.ContractRabbitmqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMqTestController{
    @Autowired
    private ContractRabbitmqService contractRabbitmqService;

    @RequestMapping(value = "contract/direct", method = RequestMethod.GET)
    public void contractDirect(String content) {
        ContractRabbitmq contract = new ContractRabbitmq();
        contract.setDateCreated(new Date());
        contract.setId(12L);
        contract.setName("liuhan");
        List<String> strList = new ArrayList<String>();
        strList.add("liu");
        strList.add("test str");
        contract.setTestStrList(strList);
        contractRabbitmqService.sendContractRabbitmqDirect(contract);
    }

    @RequestMapping(value = "contract/topic", method = RequestMethod.GET)
    public void contractTopic(String content) {
        ContractRabbitmq contract = new ContractRabbitmq();
        contract.setDateCreated(new Date());
        contract.setId(12L);
        contract.setName("liuhan");
        List<String> strList = new ArrayList<>();
        strList.add("liu");
        strList.add("test str");
        contract.setTestStrList(strList);
        contractRabbitmqService.sendContractRabbitmqTopic(contract);
    }

    @RequestMapping(value = "tenant/direct", method = RequestMethod.GET)
    public void tenantDirect(String content) {
        TenantRabbitmq tenant = new TenantRabbitmq();
        tenant.setId(12L);
        tenant.setName("liuhan");
        contractRabbitmqService.sendTenantRabbitmqDirect(tenant);
    }

    @RequestMapping(value = "tenant/topic", method = RequestMethod.GET)
    public void tenantTopic(String content) {
        TenantRabbitmq tenant = new TenantRabbitmq();
        tenant.setId(12L);
        tenant.setName("liuhan");
        contractRabbitmqService.sendTenantRabbitmqTopic(tenant);
    }
}
