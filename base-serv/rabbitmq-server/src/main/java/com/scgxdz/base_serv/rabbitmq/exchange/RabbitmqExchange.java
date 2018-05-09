package com.scgxdz.base_serv.rabbitmq.exchange;

/**
 * exchange交换机配置
 */
public interface RabbitmqExchange {
    /**
     * 合同exchange
     */
    /*final String CONTRACT_FANOUT = "CONTRACT_FANOUT";
    final String CONTRACT_TOPIC = "CONTRACT_TOPIC";
    final String CONTRACT_DIRECT = "CONTRACT_DIRECT";*/

    final String EXCHANGE_TOPIC = "default_exchange_topic";
    final String EXCHANGE_FANOUT = "default_exchange_fanout";
    final String EXCHANGE_DIRECT = "default_exchange_direct";
}
