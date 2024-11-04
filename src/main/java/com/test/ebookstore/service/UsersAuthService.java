package com.test.ebookstore.service;

import org.springframework.http.ResponseEntity;

import com.test.ebookstore.dto.request.auth.UsersEmailCheckRequestDto;
import com.test.ebookstore.dto.request.auth.UsersIdCheckRequestDto;
import com.test.ebookstore.dto.request.auth.UsersSignInRequestDto;
import com.test.ebookstore.dto.request.auth.UsersSignUpRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.auth.UsersSignInResponseDto;

public interface UsersAuthService {
    
    // Id Check 
    ResponseEntity<ResponseDto> idCheck(UsersIdCheckRequestDto dto);
    // Email Check
    ResponseEntity<ResponseDto> emailCheck(UsersEmailCheckRequestDto dto);
    // sign-up 
    ResponseEntity<ResponseDto> signUp(UsersSignUpRequestDto dto);
    // sign-in
    ResponseEntity<? super UsersSignInResponseDto> signIn(UsersSignInRequestDto dto);

}
