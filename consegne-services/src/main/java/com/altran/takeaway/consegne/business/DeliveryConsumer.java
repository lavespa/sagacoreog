package com.altran.takeaway.consegne.business;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.takeaway.consegne.bean.OrderDTO;
import com.altran.takeaway.consegne.bean.type.OrderStatusType;
import com.altran.takeaway.consegne.dao.DeliveryRepository;
import com.altran.takeaway.consegne.entity.Delivery;
import com.altran.takeaway.consegne.port.IDeliveryMessging;
import com.altran.takeaway.consegne.port.IDeliveryPublisher;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class DeliveryConsumer  implements IDeliveryMessging {

    private static final Logger logger = LoggerFactory.getLogger(DeliveryConsumer.class);

    @Autowired
    private IDeliveryPublisher deliveryPublisher;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void consumeMessage(String content) {

        try {
            OrderDTO orderDTO = objectMapper.readValue(content, OrderDTO.class);
            Delivery delivery=new Delivery();
            delivery.setAddressDTO(orderDTO.getAddressDTO());
            delivery.setOrderId(orderDTO.getId());
            deliveryRepository.save(delivery);
            logger.info("Processing delivery id "+delivery.getId()+" for order id "+orderDTO.getId());
            Thread.sleep(5000);
            orderDTO.setOrderStatus(OrderStatusType.DELIVERED);
            orderDTO.setStatusDescription("Delivered");
            deliveryPublisher.sendToOrderCallback(orderDTO);
            logger.info("Delivered order id "+orderDTO.getId());

        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(), e);
        }


    }
}
