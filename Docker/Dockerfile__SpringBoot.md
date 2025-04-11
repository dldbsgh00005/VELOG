'''
# 예제: OpenJDK 17을 사용하는 경우
FROM openjdk:17-jdk-alpine

# 프로젝트 JAR 파일 복사 (빌드 시 target/yourapp.jar 파일 생성 가정)
ARG JAR_FILE=target/yourapp.jar
COPY ${JAR_FILE} app.jar

# 애플리케이션이 8080 포트를 사용한다고 가정
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]

'''