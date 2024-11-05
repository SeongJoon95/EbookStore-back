package com.test.ebookstore.dto.response.book;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.response.ResponseCode;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.ResponseMessage;
import com.test.ebookstore.repository.resultSet.ListBooksResultSet;

import lombok.Getter;

@Getter
public class GetBooksResponseDto extends ResponseDto{
    
    List<ListBooksResultSet> listBooksResultSets;

    public GetBooksResponseDto (List<ListBooksResultSet> resultSets){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.listBooksResultSets = resultSets;
        
    }

    public static ResponseEntity<GetBooksResponseDto> success(List<ListBooksResultSet> resultSets) {
        GetBooksResponseDto responseBody = new GetBooksResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    
}
