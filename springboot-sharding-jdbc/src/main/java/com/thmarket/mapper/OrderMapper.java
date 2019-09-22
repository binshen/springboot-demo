package com.thmarket.mapper;

import com.thmarket.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> getOrderListByUserId(Integer userId);

    void createOrder(Order order);
}
