package com.test.ebookstore.dto.response;

public interface ResponseCode {
    
    // 200 OK
    String SUCCESS = "SU";

    // 400 Error
    String DUPLICATED_USER_ID = "DI";
    String DUPLICATED_EMAIL_ID = "DE";
    String DUPLICATED_GUEST_TEL_NUMBER = "DT";
    String DUPLICATED_REVIEWS = "DR";
    String NO_EXIST_GUEST_ID = "NGI"; 
    String NO_EXIST_TELNUMBER = "NT";
    String NO_EXIST_Id = "NI";
    String NO_EXIST_RESERVATION_ID = "NI";
    String NOT_MATCH_VALUE = "NV";
    String NO_EXIST_REVIEW_ID = "NRI";
    String NO_EXIST_ACCOMMODATION_NAME = "NAN";
    String NO_EXIST_BOOKMARK = "NEB";
    String NO_EXIST_PAYMENT_ID = "NEPI";
    String NO_VALUE = "NV";
    String NO_VALUE_BOOK_ID = "NVBI";
    String NO_VALUE_USER_ID = "NVUI";

    // 401 Error
    String AUTHENTICATION_FAIL = "AF";
    String TEL_AUTH_FAIL = "TAF";
    String SIGN_IN_FAIL = "SF";


    // 500 Error
    String DATABASE_ERROR = "DBE";
    String TOKEN_CREATE_FAIL = "TCF";
    String MESSAGE_SEND_FAIL = "MF";
}
