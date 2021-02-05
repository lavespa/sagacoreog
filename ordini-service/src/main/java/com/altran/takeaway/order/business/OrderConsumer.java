package com.altran.takeaway.order.business;

import java.io.IOException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.takeaway.order.bean.OrderDTO;
import com.altran.takeaway.order.dao.OrderRepository;
import com.altran.takeaway.order.entity.Order;
import com.altran.takeaway.order.port.IOrderMessaging;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OrderConsumer implements IOrderMessaging {

    private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public void callback(String message)
    {
        try {
            OrderDTO orderDTO=mapper.readValue(message, OrderDTO.class);
            Optional<Order> orderOptional=orderRepository.findById(orderDTO.getId());
            if(orderOptional.isPresent())
            {
                Order order=orderOptional.get();
                order.setStatusDescription(orderDTO.getStatusDescription());
                order.setOrderStatus(orderDTO.getOrderStatus());
                orderRepository.save(order);
            }
        }  catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
