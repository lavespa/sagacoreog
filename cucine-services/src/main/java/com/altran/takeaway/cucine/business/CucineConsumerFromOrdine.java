package com.altran.takeaway.cucine.business;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.takeaway.cucine.bean.OrderDTO;
import com.altran.takeaway.cucine.bean.type.OrderStatusType;
import com.altran.takeaway.cucine.port.ICucineMessaging;
import com.altran.takeaway.cucine.port.ICucinePublisher;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class CucineConsumerFromOrdine  implements ICucineMessaging {

    private static final Logger logger = LoggerFactory.getLogger(CucineConsumerFromOrdine.class);

    @Autowired
    private CucineService kitchenService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ICucinePublisher kithcenPublisher;

    @Override
    public void consumeMessage(String content) {

        try {
            OrderDTO orderDTO=objectMapper.readValue(content, OrderDTO.class);

            boolean started=kitchenService.process(orderDTO);
            kithcenPublisher.sendToOrderCallback(orderDTO);

            if(started) {
                logger.info("Start cooking for order id "+orderDTO.getId()+" start");
                Thread.sleep(5000);
                logger.info("Packaging start");
                orderDTO.setOrderStatus(OrderStatusType.PACKAGING);
                orderDTO.setStatusDescription("Order in packaging");

                kithcenPublisher.sendToOrderCallback(orderDTO);
                logger.info("Callback to order service sent");
                kithcenPublisher.sendToDelivery(orderDTO);
                logger.info("Order id "+orderDTO.getId()+" sent to delivery");
            }
        } catch (IOException | InterruptedException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
