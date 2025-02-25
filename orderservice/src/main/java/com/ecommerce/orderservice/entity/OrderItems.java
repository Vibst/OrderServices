package com.ecommerce.orderservice.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_order_items")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderItemId;

    // Convert List<String> to comma-separated string for DB storage
    private String orderItems; // e.g., "Laptop, Charger, Mouse"

    private String orderItemsUser;
    private boolean isActiveOrder;

    // @OneToOne
    // @JoinColumn(name = "order_id")
    // private Order order;

}

