package com.altran.takeaway.order.bean;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.altran.takeaway.order.bean.type.HamburgerType;




@Entity
public class HamburgerDTO {
	
	@Id
    @GeneratedValue
	private Integer id;

    private HamburgerType hamburgerType;

    private int quantity;

    public HamburgerDTO(){

    }

    public HamburgerDTO(HamburgerType type,int quantity){
        this.quantity=quantity;
        this.hamburgerType=type;
    }

    public HamburgerType getHamburgerType() {
        return hamburgerType;
    }

    public void setHamburgerType(HamburgerType hamburgerType) {
        this.hamburgerType = hamburgerType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
