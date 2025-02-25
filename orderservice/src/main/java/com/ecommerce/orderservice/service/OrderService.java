package com.ecommerce.orderservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.entity.OrderItems;
import com.ecommerce.orderservice.helper.EntityConvertToDTO;
import com.ecommerce.orderservice.model.OrderModel;
import com.ecommerce.orderservice.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityConvertToDTO entityConvertToDTO;

    public OrderModel saveOrder(OrderModel orderModel) {
        try {
            Order orderEntity = EntityConvertToDTO.toEntity(orderModel);
            Order savedOrder = orderRepository.save(orderEntity);
            OrderModel savedModel = EntityConvertToDTO.toModel(savedOrder);
            return  savedModel;

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'saveOrder'" + e.getMessage());

        }

    }

    // public Order saveOrder(Order order) {
    // try {
    // // Link each OrderItems to the parent Order
    // for (OrderItems item : order.getOrderItems()) {
    // item.setOrder(order);
    // }

    // // Save Order (cascades to OrderItems)
    // return orderRepository.save(order);

    // } catch (Exception e) {
    // throw new UnsupportedOperationException("Unimplemented method 'saveOrder': "
    // + e.getMessage());
    // }
    // }

    public List<Order> getAllOrder() {
        try {
            List<Order> lstValue = orderRepository.findAll();
            return lstValue;

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getAllOrder'");
        }

    }

    public Order getSkuCode(String skuCode) {
        try {

            Order skuCodeOrder = orderRepository.findBySkuCode(skuCode);
            return skuCodeOrder;

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'getSkuCode'");
        }

    }

}
