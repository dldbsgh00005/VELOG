# 필터의 목적
> Jwt 구현 시 :
- 1. Refresh Token 을 Redis에서 제거
- 2. 쿠키 무효화 (accessToken, refreshToken)

# 적용 과정
> SecurityConfig : 기본 LogoutFilter.class 제거 / CustomLogoutFilter.class 추가
```
http.logout(AbstractHttpConfigurer::disable);
http.addFilterAt(new CustomLogoutFilter(), LogoutFilter.class);
```

# 필터 구조
- RequestUri 검증
- Logged In User Validation (쿠키 획득, 복호화 등)
- Redis에서 Refresh Token 제거
- Security Context Clear
- Response
- 다음 필터로 넘어가지 않도록 마무리

# 전체 코드
```
package com.project.ds_helper.common.filter;

import com.project.ds_helper.common.enums.JwtTokenType;
import com.project.ds_helper.common.util.CookieUtil;
import com.project.ds_helper.common.util.JwtUtil;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class CustomLogoutFilter extends GenericFilterBean {

    private final RedisTemplate<String, String> redisTemplate;
    private final JwtUtil jwtUtil;
    private final CookieUtil cookieUtil;

    public CustomLogoutFilter(@Qualifier("CustomStringRedisTemplate") RedisTemplate<String, String> redisTemplate, JwtUtil jwtUtil, CookieUtil cookieUtil) {
        this.redisTemplate = redisTemplate;
        this.jwtUtil = jwtUtil;
        this.cookieUtil = cookieUtil;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    public void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        // 로그아웃 경로와 일치하지 않으면 필터 패스
        if(!UrlFilter.checkIfLogoutPath(httpServletRequest.getRequestURI())){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        log.info("Is Logout URL");
        
        // get refresh token
        String refreshToken = cookieUtil.getRefreshTokenFromCookie(httpServletRequest);

        // authentication null check
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(refreshToken == null || refreshToken.isBlank()){httpServletResponse.setStatus(401);
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.print("Not Logged In User");
            printWriter.close();
            return;}

        // extract userid from refresh token
        String userId = jwtUtil.getId(refreshToken);
        log.info("logout userId : {}", refreshToken);

        // 만약 로그인된 유저가 아니면 예외 처리 / 로그인 된 유저는 해당 없음
        if(!redisTemplate.delete(jwtUtil.toRedisRefreshTokenKey(userId))){
            log.debug("Is Not Logged In User");
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

            httpServletResponse.setStatus(401);
            PrintWriter printWriter = httpServletResponse.getWriter();
            printWriter.print("{\"message\": \"Not Logged In User\"}");
            printWriter.close();
            return;
        }
        // clear security context
        if(SecurityContextHolder.getContext().getAuthentication() != null){SecurityContextHolder.clearContext();}

        httpServletResponse.setStatus(200);

        // expire access, refresh token
        httpServletResponse.addCookie(cookieUtil.expireCookieByCookieName(JwtTokenType.ACCESS_TOKEN_NAME.getTokenName()));
        httpServletResponse.addCookie(cookieUtil.expireCookieByCookieName(JwtTokenType.REFRESH_TOKEN_NAME.getTokenName()));

        // JSON body 반환
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write("{\"message\": \"Logout successful\"}");
        writer.close();
        return;
    }
}


```
