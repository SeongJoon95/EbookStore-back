package com.test.ebookstore.filter;

import java.io.IOException;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.test.ebookstore.provider.JwtProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    
    private final JwtProvider jwtProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
    
        try {
    
            String token = parseBearerToken(request);
            if (token==null) {
                filterChain.doFilter(request, response);
                return;
            }

            String guestId = jwtProvider.validate(token);
            if (guestId == null) {
                filterChain.doFilter(request, response);
                return;
            }

            setContext(request, guestId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }
    private String parseBearerToken(HttpServletRequest request) {
        
        String authorization = request.getHeader("Authorization");

        boolean hasAuthorization = StringUtils.hasText(authorization);
        if(!hasAuthorization) return null;

        boolean isBearer = authorization.startsWith("Bearer ");
        if(!isBearer) return null;

        String token = authorization.substring(7);
        return token;
    }

    private void setContext(HttpServletRequest request, String guestId) {
        AbstractAuthenticationToken authenticationToken =
            new UsernamePasswordAuthenticationToken(guestId, null, AuthorityUtils.NO_AUTHORITIES);
        
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContext securityContext = SecurityContextHolder.createEmptyContext();

            securityContext.setAuthentication(authenticationToken);
            
            SecurityContextHolder.setContext(securityContext);
    }
}
