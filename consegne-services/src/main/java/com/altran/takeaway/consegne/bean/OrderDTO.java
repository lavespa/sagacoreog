package com.altran.takeaway.consegne.bean;


import java.util.List;

import com.altran.takeaway.consegne.bean.type.CookingType;
import com.altran.takeaway.consegne.bean.type.OrderStatusType;


public class OrderDTO {

    private String id;

    private String statusDescription;

    private CookingType cookingType;

    private OrderStatusType orderStatus;

    private List<HamburgerDTO> hamburgerList;

    private AddressDTO addressDTO;
    private float price;

    public List<HamburgerDTO> getHamburgerList() {
        return hamburgerList;
    }

    public void setHamburgerList(List<HamburgerDTO> hamburgerList) {
        this.hamburgerList = hamburgerList;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public OrderStatusType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusType orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public CookingType getCookingType() {
        return cookingType;
    }

    public void setCookingType(CookingType cookingType) {
        this.cookingType = cookingType;
    }
}
