package com.test.ebookstore.repository.resultSet;

public interface PaymentStateResultSet {
    
    Integer getOrdersId(); // 결제번호
    String getOrdersDate(); // 결제 날
    Integer getTotalPrice(); // 결제 가격
    String getState();// 결제상태
    String getUserName(); // 유저 이름
    Integer getOrderitemsCount(); // 수량
    String getBooksName(); // 책 이름
    String getBooksAuthorName(); // 지은이
}
