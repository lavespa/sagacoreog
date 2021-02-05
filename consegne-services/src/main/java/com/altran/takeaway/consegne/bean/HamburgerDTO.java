package com.altran.takeaway.consegne.bean;


import com.altran.takeaway.consegne.bean.type.HamburgerType;


public class HamburgerDTO {

    private HamburgerType hamburgerType;

    private int quantity;

    public HamburgerDTO(){

    }

    public HamburgerDTO(HamburgerType type, int quantity){
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
