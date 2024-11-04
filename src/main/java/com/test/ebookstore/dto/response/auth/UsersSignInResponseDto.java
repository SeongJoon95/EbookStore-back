package com.test.ebookstore.dto.response.auth;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.response.ResponseCode;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.ResponseMessage;

import lombok.Getter;

@Getter
public class UsersSignInResponseDto extends ResponseDto{
    
    private String accessToken;
    private Integer expiration;

    private UsersSignInResponseDto(String accessToken) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.accessToken = accessToken;
        this.expiration = 10*60*60; // 10시간 유효
    }

    public static ResponseEntity<UsersSignInResponseDto> success(String accessToken) {
        UsersSignInResponseDto responseBody = new UsersSignInResponseDto(accessToken);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    };
}
