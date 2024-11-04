package com.test.ebookstore.provider;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {
    
    @Value("${jwt.secret}")
    private String secetkey;

    public String create(String userId) {
        
        Date expiredDate = Date.from(Instant.now().plus(10,ChronoUnit.HOURS));

        String jwt = null;

        try {
            
            Key key = Keys.hmacShaKeyFor(secetkey.getBytes(StandardCharsets.UTF_8));
            
            jwt = Jwts.builder()
                .signWith(key, SignatureAlgorithm.HS256)
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(expiredDate)
                .compact();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return jwt;
    }

    // 검증 메서드
    public String validate(String jwt) {
        String userId = null;

        try {
            
            Key key = Keys.hmacShaKeyFor(secetkey.getBytes(StandardCharsets.UTF_8));

            userId = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)
                    .getBody()
                    .getSubject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;   
        }

        return userId;
    }
}
