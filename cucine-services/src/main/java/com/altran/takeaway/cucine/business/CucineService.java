package com.altran.takeaway.cucine.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altran.takeaway.cucine.bean.HamburgerDTO;
import com.altran.takeaway.cucine.bean.OrderDTO;
import com.altran.takeaway.cucine.bean.type.HamburgerType;
import com.altran.takeaway.cucine.bean.type.OrderStatusType;
import com.altran.takeaway.cucine.dao.HamburgerRepository;
import com.altran.takeaway.cucine.entity.Hamburger;


@Service
public class CucineService {

    private static final Logger logger = LoggerFactory.getLogger(CucineService.class);


    @Autowired
    private HamburgerRepository hamburgerRepository;

    public void addHamburger(HamburgerDTO hamburgerDTO)
    {
        for(int i=0;i<hamburgerDTO.getQuantity();i++)
        {
            Hamburger hamburger=new Hamburger();
            hamburger.setHamburgerType(hamburgerDTO.getHamburgerType());
            hamburgerRepository.save(hamburger);
        }
    }

    public List<HamburgerDTO> getStatus(){
        List<HamburgerDTO> list=new ArrayList<>();
        List<Hamburger> hamburgerList=hamburgerRepository.findAll();
        if(hamburgerList!=null) {
            Map<HamburgerType,Integer> hamburgerTypeSizeMap=new HashMap<>();
            for (Hamburger hamburger : hamburgerList) {
                Integer currentSize=null;
                if((currentSize=hamburgerTypeSizeMap.get(hamburger.getHamburgerType()))!=null)
                    currentSize = currentSize.intValue() + 1;
                else
                    currentSize=1;
                hamburgerTypeSizeMap.put(hamburger.getHamburgerType(),currentSize);
            }
            for(Map.Entry<HamburgerType,Integer> entry:hamburgerTypeSizeMap.entrySet())
                list.add(new HamburgerDTO(entry.getKey(),entry.getValue()));
        }
        return list;
    }

    public synchronized boolean process(OrderDTO orderDTO)
    {
        List<HamburgerDTO> hamburgerDTOList= orderDTO.getHamburgerList();
        List<Hamburger> candidatesHamburger=new ArrayList<>();
        for(HamburgerDTO hDto:hamburgerDTOList)
        {
            List<Hamburger> hamburgerList= hamburgerRepository.findByHamburgerTypeIs(hDto.getHamburgerType());
            if(hamburgerList!=null&&hamburgerList.size()>=hDto.getQuantity())
            {

                int i=0;
                for(Hamburger hamburger:hamburgerList) {
                    ++i;
                    candidatesHamburger.add(hamburger);
                    if(i==hDto.getQuantity())
                        break;

                }
            }
            else {

                orderDTO.setOrderStatus(OrderStatusType.ABORTED);
                orderDTO.setStatusDescription(hDto.getHamburgerType().getDescription()+" finished, only "+hamburgerList.size()+" in the fridge");
                logger.info("Order aborted");
                return false;
            }
        }
        orderDTO.setOrderStatus(OrderStatusType.COOKING);
        orderDTO.setStatusDescription("Order in cooking");
        for(Hamburger hamburger:candidatesHamburger)
        {
                hamburgerRepository.delete(hamburger);
        }

        return true;
    }
}
