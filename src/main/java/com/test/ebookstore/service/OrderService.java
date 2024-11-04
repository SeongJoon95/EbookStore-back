package com.test.ebookstore.service;

import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.request.orders.OrdersRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;

public interface OrderService {

    // 주문정보 저장
    ResponseEntity<ResponseDto> orders(OrdersRequestDto dto);
    
}
