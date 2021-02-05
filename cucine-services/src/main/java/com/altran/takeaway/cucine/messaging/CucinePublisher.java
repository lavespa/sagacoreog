package com.altran.takeaway.cucine.messaging;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.altran.takeaway.cucine.bean.OrderDTO;
import com.altran.takeaway.cucine.port.ICucinePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class CucinePublisher implements ICucinePublisher {


    private final static String TOPIC_ORDER_CALLBACK ="orderservicecallback";

    private final static String TOPIC_DELIVERY="deliveryservice";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public void sendToOrderCallback(OrderDTO orderDTO) throws JsonProcessingException{
        kafkaTemplate.send(TOPIC_ORDER_CALLBACK,objectMapper.writeValueAsString(orderDTO));
    }

    @Override
    public void sendToDelivery(OrderDTO orderDTO) throws JsonProcessingException {
        kafkaTemplate.send(TOPIC_DELIVERY,objectMapper.writeValueAsString(orderDTO));
    }



}
