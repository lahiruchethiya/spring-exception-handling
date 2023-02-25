package com.chethiya.springexceptionhandling.dao;

import com.chethiya.springexceptionhandling.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    Order findByName(String name);
}
