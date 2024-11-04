package com.test.ebookstore.repository.resultSet;

// 잠깐보류
public interface OrderResultSet {
    
    String getOrdersDate(); // 주문날짜
    Integer getTotalPrice(); // 총 가격
    String getState(); // 주문 상태
    String getUserId(); // 유저 아이디

}