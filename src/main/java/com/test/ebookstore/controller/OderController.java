package com.test.ebookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ebookstore.dto.request.orders.AfterPaymentRequestDto;
import com.test.ebookstore.dto.request.orders.BeforePaymentRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.payment.GetPaymentStateResponseDto;
import com.test.ebookstore.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OderController {
    
    private final OrderService orderService;

    @PostMapping("/beforePayment")
    // 결제전
    public ResponseEntity<ResponseDto> beforePayment(
        @RequestBody @Valid BeforePaymentRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = orderService.beforePayment(requestBody);
        return response;
    }

    // 결제후+주문에 포함된 책 정보저장
    @PatchMapping("/afterPayment/{ordersId}")
    public ResponseEntity<ResponseDto> afterPayment(
        @RequestBody @Valid AfterPaymentRequestDto requestBody,
        @PathVariable("ordersId") Integer ordersId
    ) {
        ResponseEntity<ResponseDto> response = orderService.afterPayment(requestBody,ordersId);
        return response;
    }

    // 결제내역보기
    @GetMapping("/listPaymentState/{ordersId}")
    public ResponseEntity<? super GetPaymentStateResponseDto> listPaymentState(
        @PathVariable("ordersId") Integer ordersId
    ) {
        ResponseEntity<? super GetPaymentStateResponseDto> response = orderService.listPaymentState(ordersId);
        return response;
    }
}

