# ✅ 의존성
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-api:2.8.6'
	implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.6'

# ✅ properties
 
# SPRING DOC
	springdoc.api-docs.path=/api-docs
	springdoc.writer-with-default-pretty-printer=true
	#springdoc.swagger-ui.configUrl=/swagger-config
	springdoc.swagger-ui.enabled=true
	springdoc.swagger-ui.path=/swagger-ui/index.html

# SpringDocConfig

 @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("API")
                .pathsToMatch("/**")
                .build();
    }
