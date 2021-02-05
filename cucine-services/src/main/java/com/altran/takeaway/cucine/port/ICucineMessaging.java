package com.altran.takeaway.cucine.port;

import org.springframework.kafka.annotation.KafkaListener;


public interface ICucineMessaging {

    String ORDER_TOPIC="orderservice";

    @KafkaListener(topics = ORDER_TOPIC)
    void consumeMessage(String content);
}
