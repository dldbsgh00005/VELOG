```

@Tag(name = "유저")
    @Operation(summary = "카카오 회원가입 & 로그인 API")
    @GetMapping("/login")
    public ResponseEntity<?> JoinWithKakaoOauthToken(@RequestParam("code") String kakaoAuthToken,
                                                           HttpServletResponse httpServletResponse) throws InterruptedException {
        return ResponseEntity.ok(kakaoOauthService.JoinWithKakaoOauthToken(kakaoAuthToken, httpServletResponse));
    }

```
