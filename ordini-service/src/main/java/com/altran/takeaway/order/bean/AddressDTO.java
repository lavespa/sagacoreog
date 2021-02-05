package com.altran.takeaway.order.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class AddressDTO {
	
	@Id
	@GeneratedValue
	private Integer id;
    private String number;
    private String street;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderDto_id")
    private OrderDTO orderDto;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
