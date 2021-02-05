package com.altran.takeaway.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altran.takeaway.order.entity.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {


}
