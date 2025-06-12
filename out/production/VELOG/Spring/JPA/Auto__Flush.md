### ✅ Auto Flush
- Flush란? PersistenceContext ( 영속성 컨텍스트 )
에 저장된 컨텐츠를 DB에 적용 하는 것
( 변기 물 내리는게 Flush )

- Transaction이 커밋 되는 시점
- JPQL/HQL이 실행되는 시점 ( 옵션이 2가지 FALSE 기본값으로 있으나 Hibernate의 기본 동작이 Auto Flush, 대신 영향을 받는 entity만 -> 선별 작업 등의 오버헤드가 발생 가능성 있음 )
- Native Sql Query 실행 전 ( JPA의 관리를 받지 않기 때문에 일단 DB에 동기화 )

저는 일반적으로 EntityManager 객체를 직접 생성 해서
쓰기도 하는데요 ( 가령 새로운 객체 생성 및 연관 관계 맺어줘야 할 때 아직 detach 상태인 경우 영속 상태로 전환하기 위해 flush, 업데이트 된 부분 갱신 필요 시 refresh )

메소드를 의도적으로 만들어서 써도 좋겠네요

( JpaRepository 사용 시 자동으로 EntityManager 객체를 인스턴스화 해주는데 굳이 새로 생성하는 것에 대해 막연한 불안감이 있었음 )