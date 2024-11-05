package com.test.ebookstore.service.Implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.test.ebookstore.dto.request.books.AddBooksRequestDto;
import com.test.ebookstore.dto.request.books.AddCategoriesRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.book.GetBooksResponseDto;
import com.test.ebookstore.entity.BooksEntity;
import com.test.ebookstore.entity.CategoriesEntity;
import com.test.ebookstore.repository.BooksRepository;
import com.test.ebookstore.repository.CategoriesRepository;
import com.test.ebookstore.repository.resultSet.ListBooksResultSet;
import com.test.ebookstore.service.BooksService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BooksServiceImplement implements BooksService{

    private final CategoriesRepository categoriesRepository;
    private final BooksRepository booksRepository; 

    @Override
    // addCategories
    public ResponseEntity<ResponseDto> addCategories(AddCategoriesRequestDto dto) {
        try {
            
            CategoriesEntity categoriesEntity = new CategoriesEntity(dto);
            categoriesRepository.save(categoriesEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseDto.success();
    }

    @Override
    // addBooks
    public ResponseEntity<ResponseDto> addBooks(AddBooksRequestDto dto) {
        
        String categoriseId = dto.getCategoriseId();
        
        try {
            
            boolean testCategorise = categoriesRepository.existsByCategoriesId(categoriseId);
            if(!testCategorise) return ResponseDto.noValues();

            BooksEntity booksEntity = new BooksEntity(dto);
            booksRepository.save(booksEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ResponseDto.success();
    }

    // 책 조회[등록일]
    @Override
    public ResponseEntity<? super GetBooksResponseDto> listBooksDate(String categoriesId) {

        List<ListBooksResultSet> resultSets = new ArrayList<>();

        try {
            CategoriesEntity categoriesEntity = categoriesRepository.findByCategoriesId(categoriesId);
            if(categoriesEntity == null) return ResponseDto.noValues();

            resultSets = booksRepository.listBooksDate(categoriesId);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBooksResponseDto.success(resultSets);
    }

    // 책 조회[가격]
    @Override
    public ResponseEntity<? super GetBooksResponseDto> listBooksPrice(String categoriesId) {
        
        List<ListBooksResultSet> resultSets = new ArrayList<>();

        try {
            CategoriesEntity categoriesEntity = categoriesRepository.findByCategoriesId(categoriesId);
            if(categoriesEntity == null) return ResponseDto.noValues();

            resultSets = booksRepository.listBooksPrice(categoriesId);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBooksResponseDto.success(resultSets);
    }

    // 책 조회[저자이름]
    @Override
    public ResponseEntity<? super GetBooksResponseDto> listBooksAuthorName(String categoriesId) {
        
        List<ListBooksResultSet> resultSets = new ArrayList<>();

        try {
            CategoriesEntity categoriesEntity = categoriesRepository.findByCategoriesId(categoriesId);
            if(categoriesEntity == null) return ResponseDto.noValues();

            resultSets = booksRepository.listBooksAuthorName(categoriesId);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetBooksResponseDto.success(resultSets);
    }
    
}
