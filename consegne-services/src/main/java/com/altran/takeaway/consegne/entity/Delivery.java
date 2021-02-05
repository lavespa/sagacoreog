package com.altran.takeaway.consegne.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.altran.takeaway.consegne.bean.AddressDTO;



@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne(mappedBy = "delivery", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private AddressDTO addressDTO;

    private String orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
