package com.ecommerce.orderservice.model;

import java.util.List;

import com.ecommerce.orderservice.entity.OrderItems;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok. Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderModel {

    private Long orderId;
    private String productName;
    private String orderName;
    private String skuCode;
    private List<OrderItemsModel> orderItems;

}

