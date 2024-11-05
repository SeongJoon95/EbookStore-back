package com.test.ebookstore.dto.request.books;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddCategoriesRequestDto {
    
    @NotBlank
    @Pattern(regexp = "^(철학|종교|자연과학|예술|문학|역사)$")
    private String categoriesId;
}
