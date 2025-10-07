(개인적)정의 : 공평한 알고리즘 (돌아가며 분배하는 로빈 후드)

OS, Kafka 등에서 활용

📌 OS 스케줄링 (4코어 기준, Quantum = 2초, Process = 3개)
- Quantum(Time Slice) : Process별 할당되는 시간
- Process 작업 시간이 남았더라도 Quantum이 만료되면 그 즉시 Context Switch 발생
- Quantum이 만료되기 전에 Process 작업이 종료 되면 Context Switch 발생
- Process와 Thread 모두 CPU가 스케줄링