package com.dyt.swm.godway.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiming.sun
 */
@Configuration
@EnableRabbit
public class RabbitmqConfig {

    private static final String TTL_EXCHANGE_NAME = "ttl.phyOrder.pull.exchange";
    private static final String DELAY_EXCHANGE_NAME = "delay.phyOrder.pull.exchange";
    private static final String TTL_QUEUE_NAME = "ttl.phyOrder.pull.queue";
    private static final String DELAY_QUEUE_NAME = "delay.phyOrder.pull.queue";
    private static final String TTL_ROUTKEY = "ttl.phyOrder.pull.routkey";
    private static final String DELAY_ROUTKEY = "delay.phyOrder.pull.routkey";
    private static final Integer TTL_TIME_SECOND = 43200 * 1000;

    /**
     * 设置 消息手动ack
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }

    /**
     * 死信交换机
     *
     * @return
     */
    @Bean
    public DirectExchange delayExchange() {
        DirectExchange directExchange = new DirectExchange(DELAY_EXCHANGE_NAME, true, false);
        return directExchange;
    }

    /**
     * 延迟交换机
     *
     * @return
     */
    @Bean
    public DirectExchange ttlExchange() {
        DirectExchange directExchange = new DirectExchange(TTL_EXCHANGE_NAME, true, false);
        return directExchange;
    }

    /**
     * 实际消费队列
     *
     * @return
     */
    @Bean
    public Queue delayQueue() {
        return new Queue(DELAY_QUEUE_NAME, true, false, false);
    }

    /**
     * 延迟队列
     *
     * @return
     */
    @Bean
    public Queue ttlQueue() {
        Map<String, Object> paramMap = new HashMap<>(6);
        paramMap.put("x-dead-letter-exchange", DELAY_EXCHANGE_NAME);
        paramMap.put("x-dead-letter-routing-key", DELAY_ROUTKEY);
        paramMap.put("x-message-ttl", TTL_TIME_SECOND);
        return new Queue(TTL_QUEUE_NAME, true, false, false, paramMap);
    }

    /**
     * 绑定延迟队列
     *
     * @return
     */
    @Bean
    public Binding ttlQueueBinding() {
        return BindingBuilder.bind(ttlQueue()).to(ttlExchange()).with(TTL_ROUTKEY);
    }


    /**
     * 绑定消费队列
     *
     * @return
     */
    @Bean
    public Binding delayQueueBinding() {
        return BindingBuilder.bind(delayQueue()).to(delayExchange()).with(DELAY_ROUTKEY);
    }


}
