package com.altran.takeaway.cucine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altran.takeaway.cucine.bean.HamburgerDTO;
import com.altran.takeaway.cucine.business.CucineService;
import com.altran.takeaway.cucine.port.ICucineApi;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/cucine/")
@Api(tags = "CucineServices")
public class CucineApi implements ICucineApi {

    @Autowired
    private CucineService CucineService;

    @Override
    public List<HamburgerDTO> status() {
        return CucineService.getStatus();
    }

    @Override
    public void addHamburger(HamburgerDTO hamburgerDTO) {
        CucineService.addHamburger(hamburgerDTO);
    }
}
