package com.altran.takeaway.consegne.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.altran.takeaway.consegne.entity.Delivery;


@Entity
public class AddressDTO {
	
	@Id
	@GeneratedValue
	private Integer id;
    private String number;
    private String street;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderDto_id")
    private Delivery delivery;
    
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
