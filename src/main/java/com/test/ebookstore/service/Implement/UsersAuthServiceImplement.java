package com.test.ebookstore.service.Implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.ebookstore.dto.request.auth.UsersEmailCheckRequestDto;
import com.test.ebookstore.dto.request.auth.UsersIdCheckRequestDto;
import com.test.ebookstore.dto.request.auth.UsersSignInRequestDto;
import com.test.ebookstore.dto.request.auth.UsersSignUpRequestDto;
import com.test.ebookstore.dto.response.ResponseDto;
import com.test.ebookstore.dto.response.auth.UsersSignInResponseDto;
import com.test.ebookstore.entity.UsersEntity;
import com.test.ebookstore.provider.JwtProvider;
import com.test.ebookstore.repository.UsersRepository;
import com.test.ebookstore.service.UsersAuthService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UsersAuthServiceImplement implements UsersAuthService{

    private final JwtProvider jwtProvider;
    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    // id Check
    public ResponseEntity<ResponseDto> idCheck(UsersIdCheckRequestDto dto) {
        
        String idCheck = dto.getUserId();
        
        try {
        
            boolean existsByUserId = usersRepository.existsByUserId(idCheck);
            if(existsByUserId) return ResponseDto.duplicatedUserId();
        
        } catch (Exception e) {
        
            e.printStackTrace();
            return ResponseDto.databaseError();
        
        }
        return ResponseDto.success();
    }


    @Override
    // Email Check
    public ResponseEntity<ResponseDto> emailCheck(UsersEmailCheckRequestDto dto) {
        
        String emailCheck = dto.getUserEmail();

        try {

            boolean existsByuserEmail = usersRepository.existsByUserEmail(emailCheck);
            if (existsByuserEmail) return ResponseDto.duplicatedUserEmail();
        
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseDto.databaseError();   

        }

        return ResponseDto.success();

    }


    @Override
    // sign-up
    public ResponseEntity<ResponseDto> signUp(UsersSignUpRequestDto dto) {
        
        String userId = dto.getUserId();
        String userEmail = dto.getUserEmail();
        String userPw = dto.getUserPw();

        try {
            boolean checkId = usersRepository.existsByUserId(userId);
            if(checkId) return ResponseDto.duplicatedUserId();
            
            boolean checkEmail = usersRepository.existsByUserEmail(userEmail);
            if(checkEmail) return ResponseDto.duplicatedUserEmail();

            String encodedPw = passwordEncoder.encode(userPw);
            dto.setUserPw(encodedPw);

            UsersEntity usersEntity = new UsersEntity(dto);
            usersRepository.save(usersEntity);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();   
        }

        return ResponseDto.success();
    }


    @Override
    // sign-in
    public ResponseEntity<? super UsersSignInResponseDto> signIn(UsersSignInRequestDto dto) {
        
        String userId = dto.getUserId();
        String userPw = dto.getUserPw();
        String accessToken = null;

        try {
            UsersEntity usersEntity = usersRepository.findByUserId(userId);
            if(usersEntity == null) return ResponseDto.signInFail();

            String encodedPw = usersEntity.getUserPw(); 
            boolean isMatched = passwordEncoder.matches(userPw, encodedPw);
            if(!isMatched) return ResponseDto.signInFail();

            accessToken = jwtProvider.create(userId);
            if(accessToken == null) return ResponseDto.tokenCreateFail();

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return UsersSignInResponseDto.success(accessToken);
    }
    
}
