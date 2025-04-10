```
 /** 필드 **/
//    private final Long jwtExpiration = 1000 * 60 * 10L ; /** 10분 */
    private final SecretKey secretkey;
    private final Long accessTokenExpiration;
    private final Long refreshTokenExpiration;

    /** 생성자 **/
    public JwtUtil(@Value(value = "${jwt.access.token.expiration}") Long accessTokenExpiration,
                   @Value(value = "${jwt.refresh.token.expiration}") Long refreshTokenExpiration,
                   @Value(value = "${jwt.secret}") String secret  ){
        this.secretkey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), Jwts.SIG.HS256.key().build().getAlgorithm());
        this.accessTokenExpiration = accessTokenExpiration;
        this.refreshTokenExpiration = refreshTokenExpiration;
    }

    /** 토큰 만료 여부 검증 **/
    public boolean isExpired(String token){
        return Jwts.parser().verifyWith(secretkey).build().parseSignedClaims(token).getPayload().getExpiration().before(new Date());
    }

    /** 유저 네임 획득 **/
    public String getUsername(String token){
        return Jwts.parser().verifyWith(secretkey).build().parseSignedClaims(token).getPayload().get("username", String.class);
    }

    /** 유저 권한 획득 **/
    public String getRole(String token){
        return Jwts.parser().verifyWith(secretkey).build().parseSignedClaims(token).getPayload().get("role", String.class);
    }

    /** AccessToken 발급  **/
    public String generateAccessToken(String username){
        return Jwts.builder()
                .claim("username", username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
                .signWith(secretkey)
                .compact();
    }

    /** RefreshToken 발급  **/
    public String generateRefreshToken(String username){
        return Jwts.builder()
                .claim("username", username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
                .signWith(secretkey)
                .compact();
    }
```
