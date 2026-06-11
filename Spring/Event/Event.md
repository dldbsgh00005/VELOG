# 이벤트 발행 
`ApplicationEventPublisher` 인터페이스의 구현체를 통해 이벤트를 발행한다.

## ApplicationEventPublisher
`ApplicattionEventPublish`는 interface이다.
내부의 `eventPublish()` 메소드를 사용하여 이벤트를 발행한다.
`eventPublish()`의 실제 동작은 `ApplicationEventMulticaster`에게 전달하는 것이다.
```
공식 문서의 내용을 발췌 : "Such an event publication step is effectively a hand-off to the multicaster."
```
즉, 핵심 클래스는 `ApplicationEventMulticaster`에서 이루어진다.

# 이벤트 캐스팅
## ApplicationEventMulticaster

# 이벤트 리스닝 
## @EventListener
`@EventListener`을 `SpringBootApplication` 위에 작성 시 애플리케이션 시작 시에 전체 EventListener를 스캔한다.
<br> 
EventListener를 `ApplicationListener` 인터페이스를 통해 직접 구현할 수도 있다.

