package com.altran.takeaway.order.bean;




import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.altran.takeaway.order.bean.type.CookingType;
import com.altran.takeaway.order.bean.type.OrderStatusType;


@Entity
public class OrderDTO {
	
	@Id
    @GeneratedValue
    private Integer id;

    private String statusDescription;

    private CookingType cookingType;

    private OrderStatusType orderStatus;
    
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
        )
    private List<HamburgerDTO> hamburgerList;
    
    @OneToOne(mappedBy = "orderDto", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
