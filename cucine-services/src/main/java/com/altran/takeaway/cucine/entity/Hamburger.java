package com.altran.takeaway.cucine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.altran.takeaway.cucine.bean.type.HamburgerType;



@Entity
public class Hamburger  {

    @Id
    @GeneratedValue
    private Integer id;
    
    private HamburgerType hamburgerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HamburgerType getHamburgerType() {
        return hamburgerType;
    }

    public void setHamburgerType(HamburgerType hamburgerType) {
        this.hamburgerType = hamburgerType;
    }
}
