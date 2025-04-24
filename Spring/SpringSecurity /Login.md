# Spring Security에서 로그인 진행 Flow

## UsernamePasswordAuthenticationFilter을 사용 할 때 Flow
1. UsernamePasswordAuthenticationFilter ( UsernamePasswordAuthenticationToken 객체 생성 ) 
2. AuthenticationManager의 authenticate()에 UsernamePasswordAuthenticationToken을 인자로 담아 인증 진행
3. 이후 ProviderManager, DaoAuthenticationProvider을 호출.
4. DaoAuthenticationProvider에서 UserDetailsService의 loadByUsername() 메소드를 호출하여 DB에서 User 정보를 획득 및 UserDetails 객체에 담아 반환
5. authenticationManager까지 반환 되어 authenticate() 메소드 실행
6. 인증 결과에 따라 UsernamePasswordAuthenticationFilter에서 SuccessHandler, FailureHandler 둘 중 하나를 실행하게 됨

## Custom 해야 할 부분
- UsernamePasswordAuthenticationFilter
- UserDetailsService
- UserDetails

![image](https://github.com/user-attachments/assets/ba8c5d0d-60b1-4cbb-812d-423ab5f5848d) 
