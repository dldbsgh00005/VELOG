```
@Bean
    UrlBasedCorsConfigurationSource corsConfig(){

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOriginPatterns(Arrays.asList("http://localhost:3000", "http://localhost:5173")); // 개발용
        config.setAllowedHeaders(Arrays.asList("*")); // 개발용
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
        config.setExposedHeaders(Arrays.asList("*"));
        config.setMaxAge(Duration.ofMinutes(30)); // 개발용
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource corsConfig = new UrlBasedCorsConfigurationSource();
        corsConfig.registerCorsConfiguration("/**", config);
        return corsConfig;
    }
```
