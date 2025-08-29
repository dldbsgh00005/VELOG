# CompletableFuture 응답 속도 측정 메소드
<img width="651" height="391" alt="image" src="https://github.com/user-attachments/assets/60799004-b87b-483b-8aaf-db5b1e66b6b8" />

# 동기 처리 응답 속도 측정 메소드
<img width="611" height="284" alt="image" src="https://github.com/user-attachments/assets/130a9b2c-66e8-481b-9e80-39c162f713f2" />

# 실행 코드
<img width="527" height="281" alt="image" src="https://github.com/user-attachments/assets/6ff9d436-d315-499a-a121-c9e430f01327" />

# 결과
<img width="271" height="220" alt="image" src="https://github.com/user-attachments/assets/ea95476a-1683-472e-8424-b081176e6e13" />

# 결론 
CompletableFuture는 병렬 처리 -> 동기 처리보다 느린 이유는?
- 큐 관리 + 스레드 스케줄링 + 컨텍스트 스위칭 비용이 병렬처리 함으로서 얻는 이익보다 작아서

CompletableFuture 의 효과적인 사용처
- I/O-Bound 보다는 CPU-Bound에서 유리
- 병렬성이 있는 작업에 유리
- 작업량이 충분히 큰 작업에 유리
