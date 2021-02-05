package com.altran.takeaway.cucine.port;

import com.altran.takeaway.cucine.bean.OrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;



public interface ICucinePublisher {

    void sendToOrderCallback(OrderDTO orderDTO) throws JsonProcessingException;

    void sendToDelivery(OrderDTO orderDTO) throws JsonProcessingException;
}
