package com.test.ebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.OrderItemsEntity;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer>{
    
    
}
