package com.test.ebookstore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.ebookstore.dto.request.auth.UsersEmailCheckRequestDto;
import com.test.ebookstore.dto.request.auth.UsersIdCheckRequestDto;
import com.test.ebookstore.dto.request.auth.UsersSignInRequestDto;
import com.test.ebookstore.dto.request.auth.UsersSignUpRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.auth.UsersSignInResponseDto;
import com.test.ebookstore.service.UsersAuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UsersAuthController {
    
    private final UsersAuthService usersAuthService;

    // 아이디 중복확인
    @PostMapping("/id-check")
    public ResponseEntity<ResponseDto> userIdCheck(
        @RequestBody @Valid UsersIdCheckRequestDto requestBody
        ){
            ResponseEntity<ResponseDto> response = usersAuthService.idCheck(requestBody);
            return response;  
        }
        
    // 이메일 중복확인
    @PostMapping("/email-check")
    public ResponseEntity<ResponseDto> userEmailCheck(
        @RequestBody @Valid UsersEmailCheckRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = usersAuthService.emailCheck(requestBody);
        return response;  
    }
    
    // 회원가입
    @PostMapping("/users/register")
    public ResponseEntity<ResponseDto> signUp(
        @RequestBody @Valid UsersSignUpRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = usersAuthService.signUp(requestBody);
        return response;  
    }
    
    // 로그인
    @PostMapping("/users/login")
    public ResponseEntity<? super UsersSignInResponseDto> signIp(
        @RequestBody @Valid UsersSignInRequestDto requestBody
    ){
        ResponseEntity<? super UsersSignInResponseDto> response = usersAuthService.signIn(requestBody);
        return response;  
    }

    
}
