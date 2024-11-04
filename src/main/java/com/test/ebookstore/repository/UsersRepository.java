package com.test.ebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String> {
    
    // 아이디 확인 검사
    boolean existsByUserId(String userId);
    // 이메일 확인 검사
    boolean existsByUserEmail(String userEmail);

    UsersEntity findByUserId(String userId);

}