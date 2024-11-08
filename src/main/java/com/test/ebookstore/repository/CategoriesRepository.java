package com.test.ebookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.CategoriesEntity;

@Repository
public interface CategoriesRepository extends JpaRepository<CategoriesEntity, String>{
    
    boolean existsByCategoriesId(String categoriesId);

    CategoriesEntity findByCategoriesId(String categoriesId);
}
