package com.altran.takeaway.cucine.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altran.takeaway.cucine.bean.type.HamburgerType;
import com.altran.takeaway.cucine.entity.Hamburger;


@Repository
public interface HamburgerRepository extends JpaRepository<Hamburger, Integer> {
    List<Hamburger> findByHamburgerTypeIs(HamburgerType hamburgerType);

}
