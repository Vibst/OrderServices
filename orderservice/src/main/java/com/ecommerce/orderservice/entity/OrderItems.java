package com.ecommerce.orderservice.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "t_order-Items")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long orderItemId;
    public List<String> orderItems;
    public String orderItemsUser;
    public boolean isActiveOrder;
    
}
