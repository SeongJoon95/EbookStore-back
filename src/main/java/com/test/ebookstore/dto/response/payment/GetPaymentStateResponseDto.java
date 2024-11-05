package com.test.ebookstore.dto.response.payment;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.response.ResponseCode;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.ResponseMessage;
import com.test.ebookstore.repository.resultSet.PaymentStateResultSet;

import lombok.Getter;

@Getter
public class GetPaymentStateResponseDto extends ResponseDto{
    
    List<PaymentStateResultSet> paymentStateResultSets;

    public GetPaymentStateResponseDto(List<PaymentStateResultSet> resultSets) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.paymentStateResultSets = resultSets;
    }

    public static ResponseEntity<GetPaymentStateResponseDto> success(List<PaymentStateResultSet> resultSets) {
        GetPaymentStateResponseDto responseBody = new GetPaymentStateResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}