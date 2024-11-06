package com.test.ebookstore.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto {
    
    private String code;
    private String message;

    // 성공 응답을 반환(HTTO 200 OK)
    public static ResponseEntity<ResponseDto> success(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    // 로그인 실패 응답을 반환 (HTTP 401 Unauthorized)
    public static ResponseEntity<ResponseDto>  signInFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.SIGN_IN_FAIL, ResponseMessage.SIGN_IN_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 토큰이 생성되지 않은 경우 실패 응답을 반환
    public static ResponseEntity<ResponseDto> tokenCreateFail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.TOKEN_CREATE_FAIL, ResponseMessage.TOKEN_CREATE_FAIL);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    // 중복된 사용자 Id 응답 반환
    public static ResponseEntity<ResponseDto> duplicatedUserId() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_USER_ID, ResponseMessage.DUPLICATED_USER_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
    // 중복된 사용자 Email 응답 반환
    public static ResponseEntity<ResponseDto> duplicatedUserEmail() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_EMAIL_ID, ResponseMessage.DUPLICATED_EMAIL_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 리뷰 유효성 검사(유저Id,책Id) 있을경우
    public static ResponseEntity<ResponseDto> duplicatedReviews(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_REVIEWS, ResponseMessage.DUPLICATED_REVIEWS);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
    
    // 두 값이 같이 않을 경우
    public static ResponseEntity<ResponseDto> notMatchValue(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_MATCH_VALUE, ResponseMessage.NOT_MATCH_VALUE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 없는 값일 경우
    public static ResponseEntity<ResponseDto> noValues(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_VALUE, ResponseMessage.NO_VALUE);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // BooksId 가 없을경우
    public static ResponseEntity<ResponseDto> noValuesBookId(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_VALUE_BOOK_ID, ResponseMessage.NO_VALUE_BOOK_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // UserId 가 없을경우
    public static ResponseEntity<ResponseDto> noValueUserId(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NO_VALUE_USER_ID, ResponseMessage.NO_VALUE_USER_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    // 데이터베이스 오류 응답을 반환.
    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
