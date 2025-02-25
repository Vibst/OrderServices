package com.ecommerce.orderservice.model;

import java.util.List;


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
public class OrderItemsModel {

    private Long orderItemId;
    private List<String> orderItems; // Kept as List in DTO for API
    private String orderItemsUser;
    private boolean isActiveOrder;

}
