package com.chethiya.springexceptionhandling.controller;

import com.chethiya.springexceptionhandling.dao.OrderDao;
import com.chethiya.springexceptionhandling.exception.OrderServiceException;
import com.chethiya.springexceptionhandling.model.Order;
import com.chethiya.springexceptionhandling.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderDao orderDao;

    @GetMapping("/getPrice/{productName}")
    public String getOrderPrice(@PathVariable String productName) throws OrderServiceException {
        double amount = service.getPrice(productName);

        return "Amount of Product "+ productName + "is " + amount;
    }

    @GetMapping("/save")
    public String saveData(){
        List<Order> orders = List.of(new Order(111, "Mobile","Electronic",2),
                new Order(222, "Keyboard", "Electronic", 3), new Order(333, "HeadPhone", "Electronnic",
                        4));

        orderDao.saveAll(orders);
        return "done";

    }

}
