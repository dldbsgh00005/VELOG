```

/ 토큰 응답
@Data
public class KakaoTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("expires_in")
    private int expiresIn;
    // … 기타 필드
}


```
