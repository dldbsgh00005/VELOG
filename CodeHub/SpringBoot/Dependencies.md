```
/** JPA **/
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

/** MAIL **/
implementation 'org.springframework.boot:spring-boot-starter-mail'

/** THYMELEAF **/
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'

/** VALIDATION **/
implementation 'org.springframework.boot:spring-boot-starter-validation'
	
/** SECURITY **/
implementation 'org.thymeleaf.extras:thymeleaf-extras-springsecurity6'
implementation 'org.springframework.boot:spring-boot-starter-security'

/** WEB */
implementation 'org.springframework.boot:spring-boot-starter-web'

/** WEB SOCKET */
implementation 'org.springframework.boot:spring-boot-starter-websocket'
implementation 'org.springframework.boot:spring-boot-starter-webflux'

/** DB */
runtimeOnly 'com.mysql:mysql-connector-j'
implementation 'org.springframework.boot:spring-boot-starter-data-redis'

/** CONFIGURATION **/
developmentOnly 'org.springframework.boot:spring-boot-devtools'
annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'

/** JJWT **/
implementation 'io.jsonwebtoken:jjwt-api:0.12.3'
runtimeOnly 'io.jsonwebtoken:jjwt-impl:0.12.3'
runtimeOnly 'io.jsonwebtoken:jjwt-jackson:0.12.3' // JSON 처리 라이브러리

/** LOMBOK **/
annotationProcessor 'org.projectlombok:lombok'
compileOnly 'org.projectlombok:lombok'

/** TEST */
testImplementation 'org.springframework.security:spring-security-test'
testImplementation 'org.springframework.boot:spring-boot-starter-test'
testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
```
