package com.thmarket.service;

import com.thmarket.mapper.OrderMapper;
import com.thmarket.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrderListByUserId(Integer userId) {
        return orderMapper.getOrderListByUserId(userId);
    }

    public void createOrder(Order order) {
        orderMapper.createOrder(order);
    }
}
