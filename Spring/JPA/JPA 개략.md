# JPA 개략

# ORM ( Object Relation Mapping )

ORM은 개념이고 이것을 구현한 구현체 Hibernate ( 등등 있지만 메인 스트림은 Hibernate )  

# Hiberanate를 자바에 맞게 최적화 한 것이 JPA ( Java Persistence API ) 


JPA의 장점
- 모든 엔티티는 객체다.
- 객체가 할 수 있는 일은 다 할 수 있다.
- @Entity 어노테이션이 붙은 클래스를 인식해서 DDL 실행을 자동화 할 수 있다. ( 해야만 한다 )
- JPQL 을 지원한다. ( 객체로 SQL문을 짤 수 있다. ) 
- SQL도 지원한다. ( 메소드 생성시 @Query 어노테이션의 인자로 nativeQuery = true 설정 ) 
- 트랜잭션 관리가 용이하다 @Transactional , flush , refresh 메소드 지원 ) 
- 지연연산 ( fetch = FetchType.LAZY ) 지원
- 메소드 명명 규칙으로 손쉬운 메소드 생성이 가능하다.
- @Repository 어노테이션만 붙이면 구현체는 알아서 만들어준다. 

- etc
