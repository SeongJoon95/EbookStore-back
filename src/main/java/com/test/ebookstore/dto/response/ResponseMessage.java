package com.test.ebookstore.dto.response;

public interface ResponseMessage {
    
    // 200 OK
    String SUCCESS = "Success.";

    // 400 Error
    String DUPLICATED_USER_ID = "Duplicated user id.";
    String DUPLICATED_EMAIL_ID = "Duplicated user Email.";
    String DUPLICATED_GUEST_TEL_NUMBER = "Duplicated guest telNumber.";
    String NO_EXIST_GUEST_ID = "No exist guest Id.";
    String NO_EXIST_TELNUMBER = "No exist telNumber.";
    String NO_EXIST_Id = "No exist id.";
    String NO_EXIST_RESERVATION_ID = "No exist reservation id";
    String NOT_MATCH_VALUE = "Not match value.";
    String NO_EXIST_REVIEW_ID = "No exist review id.";
    String NO_EXIST_ACCOMMODATION_NAME = "No exist accommodation name.";
    String NO_EXIST_BOOKMARK = "No exist BookMark id And accommodation name";
    String NO_EXIST_PAYMENT_ID ="No exist Payment Id";
    String NO_VALUE = "No Value.";

    // 401 Error
    String AUTHENTICATION_FAIL = "Authentication fail.";
    String TEL_AUTH_FAIL = "Tel number authentication failed.";
    String SIGN_IN_FAIL = "Sign in failed.";

    // 500 Error
    String DATABASE_ERROR = "Database error.";
    String TOKEN_CREATE_FAIL = "Token creation failed.";
    String MESSAGE_SEND_FAIL = "Auth number send failed.";
}
