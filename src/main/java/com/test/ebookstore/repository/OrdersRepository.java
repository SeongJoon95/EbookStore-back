package com.test.ebookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.OrdersEntity;
import com.test.ebookstore.repository.resultSet.PaymentStateResultSet;
@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
    
    OrdersEntity findByOrdersId(Integer ordersId);
    
    // 주문번호 유효성검사
    boolean existsByOrdersId(Integer ordersId);


    @Query(value = 
    "SELECT" +
    "    O.orders_id as ordersId, " +
    "    O.orders_date as ordersDate, " +
    "    O.total_price as totalPrice, " +
    "    O.state as state, " +
    "    U.user_name as userName, " +
    "    OI.orderitems_count as orderitemsCount, " +
    "    B.books_name as booksName, " +
    "    B.books_author_name as booksAuthorName " +
    "FROM orders as O JOIN orderitems as OI " +
    "ON O.orders_id = OI.orders_id " +
    "JOIN books as B " +
    "ON OI.books_id = B.books_id " +
    "JOIN users as U " +
    "ON O.user_id = U.user_id " +
    "WHERE O.orders_id = :ordersId ",
    nativeQuery = true)
    List<PaymentStateResultSet> listPaymentState(@Param("ordersId") Integer ordersId);

    @Query(value = 
    "SELECT * FROM orders " +
    "WHERE user_id = :userId " +
    "AND state = \"결제완료\" " ,
    nativeQuery = true)
    OrdersEntity findByUserId(@Param("userId") String UserId);
}
