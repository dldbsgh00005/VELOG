# Cors 설정을 SecurityConfig에 했을 경우
스프링 시큐리티보다 먼저 실행되는 것이 ( 예 : Nginx ) 가 시큐리티의 설정을 덮을 가능성 있음

@Configuration
public class CorsConfig implements WebMvcConfigurer {

        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOriginPatterns("*")
                    .allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS")
                    .allowedHeaders("Authorization", "Content-Type", "XSRF-TOKEN")
                    .exposedHeaders("Custom-Header")
                    .allowCredentials(true)
                    .maxAge(3600);
        }

}
