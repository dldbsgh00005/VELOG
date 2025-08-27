# 구성
- Virtual Thread : JVM에서 관리되는 가상의 스레드
- Mount : Virtual Thread가 Carrier Thread에 탑승하여 실행되는 것
- UnMount : Virtual Thread가 동작(DB, Socket, Sleep 등)하는 시점에 Carrier Thread에서 하차하여 실행되지 대기하는 것
- Continuation : UnMount 되는 시점에 Virtual Thread의 레지스터, 호출 스택 등의 정보를 저장하는 곳 (Process에서 Thread간 Context Switching이 일어날 때 PCB가 스레드의 정보를 저장하는 것과 동일)
- Carrier Thread (OS Thread / Platform Thread)

# 장점
- Thread 스케줄링을 JVM 내에서 한다.
- OS의 부담 감소

# 단점
- Context Switching 비용 발생
- CPU 성능을 올려주는 것은 아니다. CPU 자체 성능은 여전히 중요

