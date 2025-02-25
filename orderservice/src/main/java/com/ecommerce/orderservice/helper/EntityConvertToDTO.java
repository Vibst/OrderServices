package com.ecommerce.orderservice.helper;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ecommerce.orderservice.entity.Order;
import com.ecommerce.orderservice.entity.OrderItems;
import com.ecommerce.orderservice.model.OrderItemsModel;
import com.ecommerce.orderservice.model.OrderModel;

@Component
public class EntityConvertToDTO {


    // public Order convertToEntity(OrderModel orderDTO) {
    //     Order order = new Order();
    //     BeanUtils.copyProperties(orderDTO, order);
    //     return order;

    // }

     public static Order toEntity(OrderModel model) {
        Order order = new Order();
        order.setOrderId(model.getOrderId());
        order.setOrderName(model.getOrderName());
        order.setProductName(model.getProductName());
        order.setSkuCode(model.getSkuCode());

        List<OrderItems> items = model.getOrderItems().stream().map(itemModel -> {
            OrderItems item = new OrderItems();
            item.setOrderItems(String.join(", ", itemModel.getOrderItems())); // Convert List<String> to String
            item.setOrderItemsUser(itemModel.getOrderItemsUser());
            item.setActiveOrder(itemModel.isActiveOrder());
            // item.setOrder(order); // Set parent
            return item;
        }).toList();

        order.setOrderItems(items);
        return order;
    }

    // Convert Order Entity to OrderModel
    public static OrderModel toModel(Order order) {
        List<OrderItemsModel> items = order.getOrderItems().stream().map(entity -> {
            OrderItemsModel itemModel = new OrderItemsModel();
            itemModel.setOrderItemId(entity.getOrderItemId());
            itemModel.setOrderItems(List.of(entity.getOrderItems().split(", "))); // Convert String to List
            itemModel.setOrderItemsUser(entity.getOrderItemsUser());
            itemModel.setActiveOrder(entity.isActiveOrder());
            return itemModel;
        }).toList();

        return new OrderModel(
                order.getOrderId(),
                order.getProductName(),
                order.getOrderName(),
                order.getSkuCode(),
                items
        );
    }
    
}
