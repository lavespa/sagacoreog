package com.altran.takeaway.consegne.port;

import org.springframework.kafka.annotation.KafkaListener;


public interface IDeliveryMessging {

    String TOPIC_DELIVERY="deliveryservice";

    @KafkaListener(topics = TOPIC_DELIVERY)
    void consumeMessage(String content);
}
