package com.test.ebookstore.dto.request.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSignInRequestDto {
    
    @NotBlank
    private String userId;
    @NotBlank
    private String userPw;
}
