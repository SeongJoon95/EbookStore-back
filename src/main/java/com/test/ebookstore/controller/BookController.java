package com.test.ebookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ebookstore.dto.request.books.AddBooksRequestDto;
import com.test.ebookstore.dto.request.books.AddCategoriesRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.book.GetBooksResponseDto;
import com.test.ebookstore.service.BooksService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/book")
@RequiredArgsConstructor
public class BookController {
    
    private final BooksService booksService; 

    //카테고리 등록하기
    @PostMapping("/add-categories")
    public ResponseEntity<ResponseDto> addCategories(
        @RequestBody @Valid AddCategoriesRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = booksService.addCategories(requestBody);
        return response;
    }

    // 책 등록하기
    @PostMapping("/add-books")
    public ResponseEntity<ResponseDto> addBooks(
        @RequestBody @Valid AddBooksRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = booksService.addBooks(requestBody);
        return response;
    }

    // 카테고리 조회[등록일]
    @GetMapping("/list-books/date/{categoriesId}")
    public ResponseEntity<? super GetBooksResponseDto> listBooksDate(
        @PathVariable("categoriesId") String categoriesId
    ) {
        ResponseEntity<? super GetBooksResponseDto> response = booksService.listBooksDate(categoriesId);
        return response;
    }
    
    // 카테고리 조회[가격순]
    @GetMapping("/list-books/price/{categoriesId}")
    public ResponseEntity<? super GetBooksResponseDto> listBooksPrice(
        @PathVariable("categoriesId") String categoriesId
    ) {
        ResponseEntity<? super GetBooksResponseDto> response = booksService.listBooksPrice(categoriesId);
        return response;
    }
    
    // 카테고리 조회[저자]
    @GetMapping("/list-books/authorName/{categoriesId}")
    public ResponseEntity<? super GetBooksResponseDto> listBooksAuthorName(
        @PathVariable("categoriesId") String categoriesId
    ) {
        ResponseEntity<? super GetBooksResponseDto> response = booksService.listBooksAuthorName(categoriesId);
        return response;
    }
    
}
