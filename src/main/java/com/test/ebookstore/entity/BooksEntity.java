package com.test.ebookstore.entity;

import com.test.ebookstore.dto.request.books.AddBooksRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Books")
@Table(name = "books")
public class BooksEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer booksId; // 책 고유 식별번호
    private String booksName; // 책이름
    private String booksDate; // 등록일
    private String booksAuthorName; // 저자
    private Integer discountRate; // 할인율
    private String categoriesId; // 카테고리 
    private Integer booksPrice; // 책가격
    
    public BooksEntity(AddBooksRequestDto dto){
        
        this.booksName = dto.getBooksName();
        this.booksDate = dto.getBooksDate();
        this.booksAuthorName = dto.getBooksAuthorName();
        this.categoriesId = dto.getCategoriseId();
        this.booksPrice = dto.getBooksPrice();
    }
}