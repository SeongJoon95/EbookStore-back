package com.test.ebookstore.entity;

import com.test.ebookstore.dto.request.auth.UsersSignUpRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Users")
@Table(name = "users")
public class UsersEntity {
    
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String userPw;

    public UsersEntity(UsersSignUpRequestDto dto) {
        this.userId = dto.getUserId();
        this.userName = dto.getUserName();
        this.userEmail = dto.getUserEmail();
        this.userPw = dto.getUserPw();
    }
}
