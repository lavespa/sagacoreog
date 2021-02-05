package com.altran.takeaway.consegne.business;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.takeaway.consegne.bean.DeliveryDTO;
import com.altran.takeaway.consegne.dao.DeliveryRepository;
import com.altran.takeaway.consegne.entity.Delivery;


@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private DozerBeanMapper dozerBeanMapper;

    public List<DeliveryDTO> getAll()
    {
        List<Delivery> deliveryList  =deliveryRepository.findAll();
        List<DeliveryDTO> res=null;
        if(deliveryList!=null)
        {
            res=new ArrayList<>();
            for(Delivery delivery:deliveryList)
            {
                DeliveryDTO deliveryDTO=dozerBeanMapper.map(delivery,DeliveryDTO.class);
                res.add(deliveryDTO);
            }
        }
        return res;
    }
}
