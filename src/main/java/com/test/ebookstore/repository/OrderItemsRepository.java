package com.test.ebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.OrderItemsEntity;
import com.test.ebookstore.entity.OrdersEntity;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer>{
    
    @Query(value = 
    "SELECT" +
    "    OI.books_id as booksId, " +
    "    O.user_id as userId " + 
    "FROM orderitems as OI " +
    "JOIN orders as O " +
    "ON OI.orders_id = O.orders_id " +
    "WHERE OI.books_id = :bookId " +
    "AND O.user_id = :userId ",
    nativeQuery = true)
    OrdersEntity getBooksIdAndUserId(@Param("bookId") Integer bookId, @Param("userId")String userId);
    

}
