package com.test.ebookstore.service;

import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.request.books.AddBooksRequestDto;
import com.test.ebookstore.dto.request.books.AddCategoriesRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.book.GetBooksResponseDto;

public interface BooksService {
    
    // 카테고리 등록하기
    ResponseEntity<ResponseDto> addCategories(AddCategoriesRequestDto dto);
    
    // 책 등록
    ResponseEntity<ResponseDto> addBooks(AddBooksRequestDto dto);

    // 카테고리별 조회[등록일]
    ResponseEntity<? super GetBooksResponseDto> listBooksDate(String categoriesId);
    
    // 카테고리별 조회[가격]
    ResponseEntity<? super GetBooksResponseDto> listBooksPrice(String categoriesId);
    
    // 카테고리별 조회[저자이륾]
    ResponseEntity<? super GetBooksResponseDto> listBooksAuthorName(String categoriesId);
}
