package com.altran.takeaway.consegne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.takeaway.consegne.bean.DeliveryDTO;
import com.altran.takeaway.consegne.business.DeliveryService;
import com.altran.takeaway.consegne.port.IDeliveryApi;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/delivery/")
@Api(tags = "DeliveryServices")
public class DeliveryApi implements IDeliveryApi {

    @Autowired
    private DeliveryService deliveryService;

    @Override
    public List<DeliveryDTO> status() {
        return deliveryService.getAll();
    }
}
