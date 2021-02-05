package com.altran.takeaway.order.port;

import com.altran.takeaway.order.bean.OrderDTO;


public interface IOrderServicePublish {
    void sendOrder(OrderDTO orderDTO);
}
