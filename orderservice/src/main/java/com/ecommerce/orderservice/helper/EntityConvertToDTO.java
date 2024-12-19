package com.ecommerce.orderservice.helper;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.model.OrderModel;

@Component
public class EntityConvertToDTO {


    public Order convertToEntity(OrderModel orderDTO) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        return order;

    }
    
}
