package com.altran.takeaway.order.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.altran.takeaway.order.bean.OrderDTO;
import com.altran.takeaway.order.port.IOrderServicePublish;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderServicePublisher implements IOrderServicePublish {

    private static final Logger logger = LoggerFactory.getLogger(OrderServicePublisher.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final static String TOPIC="orderservice";

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void sendOrder(OrderDTO orderDTO) {
        try {
            kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(orderDTO));
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
