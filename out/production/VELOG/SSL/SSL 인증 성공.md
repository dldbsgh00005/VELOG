# 로컬 테스트용
logging:
  level:
    org.springframework.boot.ssl: DEBUG
    org.apache.tomcat.util.net.SSLUtilBase: DEBUG

server:
  port: 8443

  ssl:
    enabled: true
    # file:./src/main/resources/keystore.p12
    key-store: classpath:keystore.p12

    key-store-password: changeit
    key-password: changeit
    key-store-type: PKCS12
#    key-alias: springboot-local
