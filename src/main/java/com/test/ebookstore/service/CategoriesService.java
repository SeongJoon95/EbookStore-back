package com.test.ebookstore.service;

import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.request.books.AddCategoriesRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;

public interface CategoriesService {
    
    ResponseEntity<ResponseDto> addCategories(AddCategoriesRequestDto dto);
}
