# 스마트 포인터 개략

- 개념 : C++에는 Java의 Garabage Collector 같은 기능이 없다.

- Heap, Stack 

Garbage Collector란?
- 참조되지 않는 ( 쓸모를 다한 ) 객체들을 제거한다.
- 조금 전문적인 용어로 말 한다면? 객체 그래프 탐색이 불가능한 객체 ( == "참조되지 않는 객체")

# 스마트 포인터의 종류
1. unique_ptr : 단 하나의 스마트 포인터만 대상 객체를 가리킨다. ( 소유권을 부여했다고 한다.)
 (main 함수가 끝나거나 지역 변수일 경우 메소드가 종료되면 사라진다. >> 개념적으로 참조되지 않으면 사라진다. )

2. shared_ptr : 대상 객체를 참조하는 객체들을 파악한다. (use_count)
참조하는 객체가 0이 되면 바로 OUT

3. weak_ptr : shared_ptr의 리스크를 보완하기 위해 나온 친구다. ( 그래서 이름에 weak가 들어가나? )
shared_ptr는 아주 좋은 기능 같지만 한 가지 무서운 위험성이 있다.
바로 "순환참조" ( circular reference) 이다.

만약 A와 B가 서로를 참조하는 경우 둘의 shared_ptr의 use_count는 평생 1 아래로 내려가지 않는다. 즉 메모리상에 영원히 남는다.
이를 극복하기 위한 것이 바로 weak_ptr

weak_ptr : 대상 객체를 참조하는 객체들을 객체 그래프 탐색 할 수 있다. 하지만 shared_ptr의 use_count에는 추가되지 않는다.

# 그럼 shared_ptr의 user_count가 0이 되면 weak_ptr은 어떻게 되나요?
>> shared_ptr의 use_count가 0이 되면 shared_ptr은 소멸 되고 대상 객체로 메모리에서 해제가 됩니다.
>> 이후 weak_ptr은 만료(expired) 상태가 되고 소멸하지는 않고 있다가 "제어블록"의 모든 weak_ptr 카운트가 0이 되면 사라집니다.

# 제어 블록이란?
shared_ptr의 카운트, weak_ptr의 카운트를 포함한 관리 대상 객체의 메타데이터를 갖고 있는 "구조체".

