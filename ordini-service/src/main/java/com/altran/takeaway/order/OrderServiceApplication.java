package com.altran.takeaway.order;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootApplication
public class OrderServiceApplication {


    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    public DozerBeanMapper modelMapper() {
        DozerBeanMapper modelMapper=new DozerBeanMapper();

        return modelMapper;
    }

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

}
