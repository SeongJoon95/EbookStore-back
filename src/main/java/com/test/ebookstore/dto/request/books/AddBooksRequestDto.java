package com.test.ebookstore.dto.request.books;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddBooksRequestDto {
    
    @NotBlank
    private String booksName; // 책이름
    
    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "날짜는 yyyy-MM-dd 형식이여야합니다.")
    private String booksDate; // 등록일
    
    @NotBlank
    private String booksAuthorName; // 저자
    
    @NotBlank
    private String categoriseId; // 카테고리

    private Integer booksPrice; // 책가격
}
