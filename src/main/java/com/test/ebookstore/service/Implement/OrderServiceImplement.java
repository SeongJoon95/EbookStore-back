package com.test.ebookstore.service.Implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.ebookstore.dto.request.orders.OrdersRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.entity.OrdersEntity;
import com.test.ebookstore.repository.OrdersRepository;
import com.test.ebookstore.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService{

    private final OrdersRepository ordersRepository;

    @Override
    // 주문정보 저장
    public ResponseEntity<ResponseDto> orders(OrdersRequestDto dto) {
        
        OrdersEntity ordersEntity = null;

        try {

            ordersEntity = new OrdersEntity(dto);
            ordersRepository.save(ordersEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }
    
}
