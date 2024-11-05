package com.test.ebookstore.service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.ebookstore.dto.request.orders.AfterPaymentRequestDto;
import com.test.ebookstore.dto.request.orders.BeforePaymentRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.payment.GetPaymentStateResponseDto;
import com.test.ebookstore.entity.OrderItemsEntity;
import com.test.ebookstore.entity.OrdersEntity;
import com.test.ebookstore.repository.BooksRepository;
import com.test.ebookstore.repository.OrderItemsRepository;
import com.test.ebookstore.repository.OrdersRepository;
import com.test.ebookstore.repository.resultSet.PaymentStateResultSet;
import com.test.ebookstore.service.OrderService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService{

    private final OrdersRepository ordersRepository;
    private final OrderItemsRepository orderItemsRepository;
    private final BooksRepository booksRepository;

    @Override
    // 주문정보 저장
    public ResponseEntity<ResponseDto> beforePayment(BeforePaymentRequestDto dto) {
        
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

    @Override
    // 결제상태변경 + 결제상세정보테이블 추가
    public ResponseEntity<ResponseDto> afterPayment(AfterPaymentRequestDto dto, Integer ordersId) {
        
        String status = dto.getState();
        Integer bookId = dto.getBooksId();

        try {
            
            // url과 requestBody의 id값이 동일해야함
            Integer matchId = dto.getOrdersId();
            if(matchId != ordersId) return ResponseDto.notMatchValue();

            OrdersEntity ordersEntity = ordersRepository.findByOrdersId(ordersId);
            if(ordersEntity == null) return ResponseDto.noValues();
            
            ordersEntity.setState(status);
            
            boolean existsBookId = booksRepository.existsByBooksId(bookId);
            if(!existsBookId) return ResponseDto.noValues();

            OrderItemsEntity orderItemsEntity = new OrderItemsEntity(dto);
            orderItemsRepository.save(orderItemsEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return ResponseDto.success();
    }

    @Override
    // 결제현황List
    public ResponseEntity<? super GetPaymentStateResponseDto> listPaymentState(Integer ordersId) {

        List<PaymentStateResultSet> resultSet = new ArrayList<>();

        try {
            boolean existsOrdersId = ordersRepository.existsByOrdersId(ordersId);
            if (!existsOrdersId) return ResponseDto.noValues();

            resultSet = ordersRepository.listPaymentState(ordersId);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        
        return GetPaymentStateResponseDto.success(resultSet);

    }
    
}
