package com.altran.takeaway.consegne.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altran.takeaway.consegne.entity.Delivery;


@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {
}
