package com.test.ebookstore.dto.request.auth;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsersSignUpRequestDto {
    
    @NotBlank
    @Length(max=45)
    private String userId;
    @NotBlank
    @Length(max=4)
    private String userName;
    @NotBlank
    @Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9]).{8,13}$") 
    private String userPw;
    @NotBlank
    private String userEmail;


}
