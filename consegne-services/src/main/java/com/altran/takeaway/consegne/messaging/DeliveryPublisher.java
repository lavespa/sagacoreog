package com.altran.takeaway.consegne.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.altran.takeaway.consegne.bean.OrderDTO;
import com.altran.takeaway.consegne.port.IDeliveryPublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class DeliveryPublisher implements IDeliveryPublisher {

    private final static String TOPIC_ORDER_CALLBACK ="orderservicecallback";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public void sendToOrderCallback(OrderDTO orderDTO) throws JsonProcessingException {
        kafkaTemplate.send(TOPIC_ORDER_CALLBACK,objectMapper.writeValueAsString(orderDTO));
    }
}
