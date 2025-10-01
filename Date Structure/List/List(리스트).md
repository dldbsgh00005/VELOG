## 개념 : 요소들을 순서가 존재하는 형태로 나열한 선형(Linear) 자료구조
> 구현에 따라 Data Type을 명시할 수 있고, 안할 수도 있다. (Java의 ArrayList는 명시, Python의 List는 자료형 무관)

## 특징 : 
1. 순서가 있다.
2. 구현에 따라 동적 배열의 형태를 띄기도 한다. (ArrayList, Python의 List 등)

## JAVA 기준
List는 Interface다. 정의만 해둔 상태. 개념적이다.

## 구현체
1. ArrayList : **동적 배열**, 조회 시간 복잡도 O(1), 삽입,삭제 시간 복잡도 O(N) -> Amoltized(평균값)
2. LinkedList : 조회 시간 복잡도 O(N), 삽입 삭제 시 Next Node, Prev Node 정보만 바꾸면 됨(구현별 차이 있음).
   > 단일 연결 리스트(Singly Linked List) : next 정보만 있다.
   > 양방향 연결 리스트(Doubly Linked List) : prev, next 정보만 있다.
   > 원형 연결 리스트(Circular Linked List) : Last Node가 First Node를 가리킴. next 정보
   

