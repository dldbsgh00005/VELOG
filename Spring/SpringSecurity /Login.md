# Spring Security에서 로그인 진행 Flow

## UsernamePasswordAuthenticationFilter을 사용 할 때 Flow
1. UsernamePasswordAuthenticationFilter ( UsernamePasswordAuthenticationToken 객체 생성 ) 
2. AuthenticationManager의 authenticate()에 UsernamePasswordAuthenticationToken을 인자로 담아 인증 진행
3. 이후 ProviderManager, DaoAuthenticationProvider을 호출.
4. DaoAuthenticationProvider에서 UserDetailsService의 loadByUsername() 메소드를 호출하여 DB에서 User 정보를 획득 및 UserDetails 객체에 담아 반환
5. authenticationManager까지 반환 되어 authenticate() 메소드 실행
6. 인증 결과에 따라 UsernamePasswordAuthenticationFilter에서 SuccessHandler, FailureHandler 둘 중 하나를 실행하게 됨

## Custom 해야 할 부분
- UsernamePasswordAuthenticationFilter ( 이하 CustomLoginFilter 라고 부른다.)
- UserDetailsService (이하 CustomUserDetailsService 라고 부른다.)
- UserDetails (이하 CustomUserDetails 라고 부른다.)

![image](https://github.com/user-attachments/assets/ba8c5d0d-60b1-4cbb-812d-423ab5f5848d) 

### CustomLoginFilter 실제 소스 코드 (기본형, 흐름 이해를 위한 코드이므로 구체적인 로직들은 작성하지 않았습니다.)
```
@Slf4j
public class CustomLoginFilter extends AbstractAuthenticationProcessingFilter {

    /** 필드 **/
    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "id";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "pw";
    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher("/api/v1/admins/login", "POST");
    private RequestMatcher requiresAuthenticationRequestMatcher;
    private boolean postOnly = true;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder;
    /** 생성자 */
    public CustomLoginFilter(AuthenticationManager authenticationManager,
                             JwtUtil jwtUtil,
                             BCryptPasswordEncoder encoder,
                             RedisTemplate<String, String> redisTemplate, AdminRepository userRepository) {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER.getPattern());
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.encoder = encoder;
        this.redisTemplate = redisTemplate;
        this.userRepository = userRepository;
    }


    /** 인증 시도 **/
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException {
        /** 로그인 요청 경로 검증 **/

        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("지원하지 않는 메소드 : " + request.getMethod());
        } else {
            AdminLoginRequestDTO loginRequestDTO;
            try {
            /** JSON 파싱 **/
                loginRequestDTO = objectMapper.readValue(request.getInputStream(), AdminLoginRequestDTO.class);
            } catch (IOException e) {
                throw new RuntimeException("[Login Filter] Parsing Failed : ", e);
            }
            
            /** 유저네임, 비밀번호 획득 **/
            /** 전처리 **/
            /** 토큰화 **/
            UsernamePasswordAuthenticationToken token = UsernamePasswordAuthenticationToken.unauthenticated(id, pw);
            log.info("로그인 요청 id : {}", id);

            /** (필요 시)다중 로그인 방지 로직 추가 **/
            /** 인증 **/
            return this.authenticationManager.authenticate(token);
        }
    }

    /** 로그인 성공 시 **/
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.info("로그인 성공 로직 시작");
    }

    /** 로그인 실패 시 **/
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.info("로그인 실패 로직 시작");
    }
}
```

### CustomUserDetailsService 실제 구현 소스 코드
```
@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public CustomUserDetailsService(AdminRepository userRepository, BCryptPasswordEncoder encoder){
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {

        Admin admin = userRepository.findById(id).orElseThrow( (() -> { throw new UserNotFoundException(); }));


        log.info("[CustomUserDetailsService] adminId : {}, adminPw : {}", admin.getId(),  admin.getPw());
        log.info("[CustomUserDetailsService] password matches : {}", encoder.matches("admin", admin.getPw()));

        return new CustomUserDetails(admin);
    }
}
```

### CustomUserDetails (필요 시 getter 메소드를 추가로 커스텀 해도 됩니다.)
```
public class CustomUserDetails implements UserDetails {

    private final Admin user;

    public CustomUserDetails(Admin user){
        this.user = user;
    }

    public String getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPw();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }
}
```
