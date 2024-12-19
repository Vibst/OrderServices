package com.ecommerce.orderservice.model;

import java.util.List;

import com.ecommerce.orderservice.entity.OrderItems;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderModel {
        public Long orderId;
    public String productName;
    public String orderName;
    public String skuCode;
    public List<OrderItems> orderItems;
}
