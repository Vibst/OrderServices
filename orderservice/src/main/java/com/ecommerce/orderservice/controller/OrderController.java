package com.ecommerce.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> saveOrder(@RequestBody Order order){
        Order isOrder =  orderService.saveOrder(order);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(isOrder);
        

    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> allOrders(){
        List<Order> lstOder =orderService.getAllOrder();

        ResponseEntity.status(HttpStatus.ACCEPTED).build();
        return ResponseEntity.ok().body(lstOder);

    }

    @GetMapping("/order/{skuCode}")
    public ResponseEntity<Order> findByOrderBySkuCode( @PathVariable("skuCode") String skuCode){
        Order skuCodeOrder = orderService.getSkuCode(skuCode);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(skuCodeOrder);

    }

    
}
