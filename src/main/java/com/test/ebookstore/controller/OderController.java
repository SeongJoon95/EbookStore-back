package com.test.ebookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ebookstore.dto.request.orders.OrdersRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OderController {
    
    private final OrderService orderService;

    @PostMapping("/orders")
    // 주문정보 저장
    public ResponseEntity<ResponseDto> orders(
        @RequestBody @Valid OrdersRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = orderService.orders(requestBody);
        return response;
    }
}

