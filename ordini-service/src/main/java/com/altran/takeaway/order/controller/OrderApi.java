package com.altran.takeaway.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.takeaway.order.bean.OrderDTO;
import com.altran.takeaway.order.business.OrderService;
import com.altran.takeaway.order.port.IOrderServiceApi;


@RestController
@RequestMapping("order")
//@Api(tags = "OrderServices")
public class OrderApi implements IOrderServiceApi  {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO create(OrderDTO request) {
        return orderService.createOrder(request);
    }

    @Override
    public OrderDTO view(Integer id) {
        return orderService.getById(id);
    }
    

    @Override
    public List<OrderDTO> viewAll() {
        return orderService.getAll();
    }


}
