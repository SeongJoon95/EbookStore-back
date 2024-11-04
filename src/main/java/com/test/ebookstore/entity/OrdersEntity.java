package com.test.ebookstore.entity;

import com.test.ebookstore.dto.request.orders.OrdersRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Orders")
@Table(name = "orders")
public class OrdersEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersId;
    private String ordersDate;
    private Integer totalPrice;
    private String state;
    private String userId;
    
    public OrdersEntity(OrdersRequestDto dto){
        this.ordersDate = dto.getOrdersDate();
        this.totalPrice = dto.getTotalPrice();
        this.state = dto.getState();
        this.userId = dto.getUserId();
    }
}
