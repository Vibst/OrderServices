package com.ecommerce.orderservice.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.helper.EntityConvertToDTO;
import com.ecommerce.orderservice.model.OrderModel;
import com.ecommerce.orderservice.repository.OrderRepository;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EntityConvertToDTO entityConvertToDTO;

    public Order saveOrder(Order order) {
        try {
            OrderModel ordered = new OrderModel();
            ordered.setOrderId(order.getOrderId());
            ordered.setOrderItems(order.getOrderItems());
            ordered.setOrderName(order.getOrderName());
            ordered.setProductName(order.getProductName());
            ordered.setSkuCode(order.getSkuCode());

            Order saveOrder = entityConvertToDTO.convertToEntity(ordered);
            return orderRepository.save(saveOrder);

        } catch (Exception e) {
            throw new UnsupportedOperationException("Unimplemented method 'saveOrder'" + e.getMessage());

        }

    }


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
