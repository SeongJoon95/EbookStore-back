package com.test.ebookstore.entity;

import com.test.ebookstore.dto.request.orders.AfterPaymentRequestDto;

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
@Entity(name = "OrderItems")
@Table(name = "orderitems")
public class OrderItemsEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderItemsId; // 주문상세고유번호
    private Integer ordersId; // 주문 고유번호
    private Integer booksId; // 책 고유번호
    private Integer orderitemsCount; // 수량


    public OrderItemsEntity( AfterPaymentRequestDto dto){
        this.ordersId = dto.getOrdersId();
        this.booksId = dto.getBooksId();
        this.orderitemsCount = dto.getOrderItemsCount();
    }
}
