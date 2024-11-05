package com.test.ebookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.ebookstore.entity.BooksEntity;
import com.test.ebookstore.repository.resultSet.ListBooksResultSet;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {
    
    // 카테고리 id 조회
    BooksEntity findByCategoriesId(String categoriesId);

    // 조회[등록일]
    @Query(value = 
    "SELECT" +
    "    C.categories_id as categoriesId, " +
    "    B.books_name as BooksName, " +
    "    B.books_author_name as booksAuthorName, " +
    "    B.books_price as booksPrice, " +
    "    B.books_date as booksDate " +
    "FROM books as B JOIN categories as C " +
    "ON B.categories_id = C.categories_id " +
    "WHERE C.categories_id = :categoriesId " +
    "ORDER BY B.books_date ",
    nativeQuery = true
    )
    List<ListBooksResultSet> listBooksDate(@Param("categoriesId") String categoriesId);
    
    // 조회[가격]
    @Query(value = 
    "SELECT" +
    "    C.categories_id as categoriesId, " +
    "    B.books_name as BooksName, " +
    "    B.books_author_name as booksAuthorName, " +
    "    B.books_price as booksPrice, " +
    "    B.books_date as booksDate " +
    "FROM books as B JOIN categories as C " +
    "ON B.categories_id = C.categories_id " +
    "WHERE C.categories_id = :categoriesId " +
    "ORDER BY B.books_price ",
    nativeQuery = true
    )
    List<ListBooksResultSet> listBooksPrice(@Param("categoriesId") String categoriesId);
    
    // 조회[저자이름]
    @Query(value = 
    "SELECT" +
    "    C.categories_id as categoriesId, " +
    "    B.books_name as BooksName, " +
    "    B.books_author_name as booksAuthorName, " +
    "    B.books_price as booksPrice, " +
    "    B.books_date as booksDate " +
    "FROM books as B JOIN categories as C " +
    "ON B.categories_id = C.categories_id " +
    "WHERE C.categories_id = :categoriesId " +
    "ORDER BY B.books_author_name ",
    nativeQuery = true
    )
    List<ListBooksResultSet> listBooksAuthorName(@Param("categoriesId") String categoriesId);

    // 책 고유번호 판단유무
    boolean existsByBooksId(Integer booksId);
}
