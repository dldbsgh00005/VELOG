1. `Collections` 의 `Static 유틸 메서드`이다.
2. `원본 List`를 감싸는 `Wrapper` 기능을 한다.
3. 일시적으로 `Synchronized`를 부여하는 기능이다.
4. `Mutex` 라는 변수를 기반으로 Lock을 제어한다.
5. Lock을 메소드별로 제어한다. 즉 읽기 / 쓰기 무관하게 항상 Lock을 대기 해야한다.
6. `CopyOnWriteArrayList` 와는 다르다. 동일한 동시성 제어이나, 원본 배열을 복사한다는 점에서 차이가 있다. 
