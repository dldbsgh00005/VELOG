1. `Lock`과 다르다.
2. `Lock`을 보유한 객체가 중복해서 Lock을 요청해도 충돌(Collision)이 발생하지 않는다.
3. `tryLock()` 메소드를 제공한다. Lock의 경우 무한정 대기하지만. `tryLock()`은 boolean 값으로 가능 여부를 즉시 return 한다.
4. `tryLock`에는 `timeOut` 옵션이 있다. 일정 시간동안 Lock 점유 대기 모드를 유지할 수 있다. timeOut이 만료되면 return 한다.
5. Lock과의 철학적 차이는 개발자가 직접 Lock을 제어하기 위함이다.
