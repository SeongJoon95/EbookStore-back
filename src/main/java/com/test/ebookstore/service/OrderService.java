package com.test.ebookstore.service;

import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.request.orders.AfterPaymentRequestDto;
import com.test.ebookstore.dto.request.orders.BeforePaymentRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.payment.GetPaymentStateResponseDto;

public interface OrderService {

    //결제전[주문정보 저장]
    ResponseEntity<ResponseDto> beforePayment(BeforePaymentRequestDto dto);

    //결제후 상태값 변경 + 상세정보 저장
    ResponseEntity<ResponseDto> afterPayment(AfterPaymentRequestDto dto, Integer ordersId);

    // 결제내역현황
    ResponseEntity<? super GetPaymentStateResponseDto> listPaymentState(Integer ordersId);
    
}
