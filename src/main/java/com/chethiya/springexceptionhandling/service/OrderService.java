package com.chethiya.springexceptionhandling.service;

import com.chethiya.springexceptionhandling.dao.OrderDao;
import com.chethiya.springexceptionhandling.exception.OrderServiceException;
import com.chethiya.springexceptionhandling.model.Order;
import jakarta.persistence.PostPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

//
//    @PostPersist
//    public void addOrderDB() {
//        List<Order> orders = List.of(new Order(111, "Mobile","Electronic",2),
//                new Order(222, "Keyboard", "Electronic", 3), new Order(333, "HeadPhone", "Electronnic",
//                        4));
//        List<Order> orderList = new ArrayList<>();
//        orderList.add(new Order(111, "Mobile","Electronic",2));
//
//        Order order = new Order();
//        order.setId(123);
//        order.setName("Mobile");
//        order.setAmount(3000);
//        order.setCategory("Electronic");
//        orderDao.save(order);
//        System.out.println("hi Lahiru");
//    }

    public double getPrice(String productName) throws OrderServiceException {

        Order order = null;
        double amount = 0;
        try {
            order = orderDao.findByName(productName);
            amount = order.getAmount();
        } catch (Exception e) {
            throw new OrderServiceException("Order not Found " + productName);
        }

        return amount;
    }


}
