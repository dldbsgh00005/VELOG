```

   @Transactional(readOnly = true)
    public ResponseEntity<?> getKakaoLoginUrl() {
            log.info("login-url-responded");

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://kauth.kakao.com/oauth/authorize?")
                    .append("client_id=").append(clientId)
                    .append("&redirect_uri=").append(redirectUri)
                    .append("&response_type=code");

        return ResponseEntity.ok(stringBuilder.toString());
}




/**
     * 카카오 Oauth Token으로 회원가입
     *
     * 추후 자체 로그인 구현 시
     * 신규 카카오 회원 가입 시 자체 회원가입 여부 확인 필요
     * **/
    @Transactional
    public CompletableFuture JoinWithKakaoOauthToken(String code, HttpServletResponse httpServletResponse) throws InterruptedException {
            log.info("kakaoAuthToken : {}", code);
            
            // 카카오 토큰 조회
//            Mono<KakaoTokenResponse> kakaoTokenResponse = fetchToken(code);
            log.info("kakao token selected successfully");
            
            // 토큰에서 유저 정보 조회
//            Mono<KakaoUserResponse> kakaoUserResponse =
            return CompletableFuture.completedFuture(fetchToken(code).subscribe(kakaoTokenResponse -> fetchUserInfo(kakaoTokenResponse.getAccessToken()).subscribe(kakaoUserResponse -> {
                        log.info("kakao user responded successfully");

                        // 유저 정보 추출
                        Long socialOauthId = kakaoUserResponse.getSocialOauthId();
                        String email = kakaoUserResponse.getKakaoAccount().getEmail();
                        String name = kakaoUserResponse.getKakaoAccount().getName();
                        String profileImageUrl = kakaoUserResponse.getKakaoAccount().getProfile().getProfileImageUrl();
                        String gender = kakaoUserResponse.getKakaoAccount().getGender();
                        String ageRange = kakaoUserResponse.getKakaoAccount().getAgeRange();
                        String birthday = kakaoUserResponse.getKakaoAccount().getBirthday();
                        String birthyear = kakaoUserResponse.getKakaoAccount().getBirthyear();
                        log.info("socialOauthId : {}, email : {}, name : {}, profileImageUrl : {}, gender : {}, ageRange : {}, birthday : {},birthyear : {},"
                                , socialOauthId, email, name, profileImageUrl, gender, ageRange, birthday, birthyear);

                        // 카카오 회원가입 유무에 따른 처리 (socialOauthId, email)
                        Optional<KakaoOauth> optionalKakaoOauth = kakaoOauthRepository.findBySocialOauthIdAndOauthEmail(socialOauthId, email);
                        log.info("optionalKakaoOauth selected");
                        // 기 가입된 유저 토큰 반환 처리
                        if(optionalKakaoOauth.isPresent()){
                            log.info("Already Joined Kakao Oauth User");

                            // 토큰 발급을 위한 userId, userRole 획득
                            KakaoOauth kakaoOauth = optionalKakaoOauth.get();
                            String userId = kakaoOauth.getUser().getId();
                            UserRole userRole = kakaoOauth.getUser().getRole();
                            log.info("userId : {}, userRole : {}", userId, userRole);

                            // jwt 토큰 발급 및 쿠키 저장
                            generateJwtTokenAndPutInCookie(httpServletResponse, userId, userRole);


                        }else {
                            // Email 기반 로컬 회원가입 여부 조회
                            // 로컬 회원이 있다면 KakaoOauth에 매핑
                            // 추후 로직 추가

                            // 로컬 회원가입 미가입 신규 회원가입 처리
                            User newUser = User.builder()
                                    .name(name)
                                    .profileImageUrl(profileImageUrl)
                                    .gender(gender)
                                    .ageRange(ageRange)
                                    .birthday(birthday)
                                    .birthyear(birthyear)
                                    .build();
                            log.info("newUser is built");

                            // 신규 유저 저장
                            User user = userRepository.save(newUser);
                            log.info("user saved");

                            // KakaoOauth 빌드
                            KakaoOauth kakaoOauth = KakaoOauth.builder()
                                    .user(user)
                                    .socialOauthId(socialOauthId)
                                    .oauthEmail(email)
                                    .build();
                            log.info("kakaoOauth is built");

                            // kakaoOauth 저장
                            kakaoOauthRepository.save(kakaoOauth);
                            log.info("kakaoOauth is saved");

                            // jwt token 발급
                            String userId = user.getId();
                            UserRole userRole = user.getRole();
                            log.info("userId : {}. userRole : {}", userId, userRole);

                            // jwt 토큰 발급 및 쿠키 저장
                            generateJwtTokenAndPutInCookie(httpServletResponse, userId, userRole);


                        }
                    })));
    }





 /**
     * 1) 인가 코드를 받아 액세스 토큰으로 교환
     */
    public Mono<KakaoTokenResponse> fetchToken(String code) { // KakaoTokenResponse

        return kakaoOauthWebClient.post()
                .uri(uriBuilder -> uriBuilder
                        .path("/oauth/token")
                        .build()
                )
                .body(BodyInserters.fromFormData("grant_type", "authorization_code")
                        .with("client_id", clientId)
                        .with("client_secret", clientSecret)
                        .with("redirect_uri", redirectUri)
                        .with("code", code))
                .retrieve()
                .bodyToMono(KakaoTokenResponse.class);
    }





/**
     * 2) 받은 액세스 토큰으로 사용자 정보 조회
     */
    public Mono<KakaoUserResponse> fetchUserInfo(String accessToken) { // Mono<KakaoUserResponse>

        return WebClient.create("https://kapi.kakao.com")
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v2/user/me")
                        .build()
                )
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(KakaoUserResponse.class);
    }




/**
     * jwt token 발급 후 쿠키에 저장하는 메소드
     * **/
    public void generateJwtTokenAndPutInCookie(HttpServletResponse httpServletResponse, String userId, UserRole userRole){
        // jwt 토큰 생성
        String accessToken = jwtUtil.generateAccessToken(userId, userRole);
        String refreshToken = jwtUtil.generateRefreshToken(userId, userRole);
        log.info("accessToken : {}, refreshToken : {}", accessToken, refreshToken);

        // 쿠키에 토큰 추가
        httpServletResponse.addCookie(CookieUtil.generateAccessTokenCookie(accessToken));
        httpServletResponse.addCookie(CookieUtil.generateRefreshTokenCookie(refreshToken));
        log.info("jwt token is put in cookie");
    }














```
