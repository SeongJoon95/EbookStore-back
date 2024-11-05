package com.test.ebookstore.entity;

import com.test.ebookstore.dto.request.books.AddCategoriesRequestDto;

import jakarta.persistence.Entity;
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
@Entity(name = "Categories")
@Table(name = "categories")
public class CategoriesEntity {
    
    @Id
    private String categoriesId;

    public CategoriesEntity(AddCategoriesRequestDto dto) {
        this.categoriesId = dto.getCategoriesId();
    }
        
}
