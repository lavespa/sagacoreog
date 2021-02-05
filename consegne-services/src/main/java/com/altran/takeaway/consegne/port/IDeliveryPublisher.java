package com.altran.takeaway.consegne.port;

import com.altran.takeaway.consegne.bean.OrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface IDeliveryPublisher {

    void sendToOrderCallback(OrderDTO orderDTO) throws JsonProcessingException;
}
