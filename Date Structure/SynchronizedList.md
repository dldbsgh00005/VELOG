1. `Collections` 의 `Static 유틸 메서드`이다.
2. `원본 List`를 감싸는 `Wrapper` 기능을 한다.
3. 일시적으로 `Synchronized`를 부여하는 기능이다.
4. `ReadWriteLock`을 기반으로 동작한다.
5. 조회는 `ReadWriteLock`의 `ReadLock` 으로 제어한다. 이 때 모든 `Write` 기능이 제한된다. 하지만 모든 조회 기능은 정상 동작한다.
6. 쓰기는 `WriteLock` 으로 제어한다. 이 때 모든 조회/쓰기 기능이 제한된다.
7. 본질적으로 읽기 기능을 자유로이. 쓰기 기능에서 Thread-Safe 하기 위한 메소드이다.
8. `CopyOnWriteArrayList` 와는 다르다. 동일한 동시성 제어이나, 원본 배열을 복사한다는 점에서 차이가 있다. 
