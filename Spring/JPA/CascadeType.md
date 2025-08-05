# 개념 : 부모 엔티티의 상태를 전파한다.

## CascadeType 종류
- ALL : 모든 옵션
- PERSIST : 저장
- REMOVE : 삭제
- REFRESH : 갱신
- MERGE : 병합
- DETACH : 분리

### 사용법
- @OneToMany(casecade = {PERSIST, MERGE, REMOVE, REFRESH, DETACH})
- @OneToMany(casecade = CascadeType.PERSIST)
- @OneToMany(casecade = CascadeType.ALL)

  
