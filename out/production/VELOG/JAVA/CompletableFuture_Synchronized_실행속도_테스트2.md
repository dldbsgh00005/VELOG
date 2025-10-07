# 실행 코드
<img width="529" height="470" alt="image" src="https://github.com/user-attachments/assets/8926bf44-96c5-4231-b3e0-18cb067c08a8" />

# CompletableFuture 메소드
<img width="599" height="392" alt="image" src="https://github.com/user-attachments/assets/ef2b9045-a711-4855-89ea-dbcae60ebca5" />

# Synchronized 메소드
<img width="567" height="149" alt="image" src="https://github.com/user-attachments/assets/c897dbae-139f-4716-9be9-6c0369f968df" />

# 결과
<img width="276" height="42" alt="image" src="https://github.com/user-attachments/assets/3b91a44c-13d8-4804-b2ba-88d940e802f0" />

# 특이사항
<img width="264" height="41" alt="image" src="https://github.com/user-attachments/assets/9c3196cc-46b7-481b-b4c8-fae1ee3d05fc" />
> Thread 대기 시간이 5mills인데 응답 시간이 4millis???
>Windows/Linux 모두 milliSecond는 너무나 작은 단위라 정확한 밀리초를 보장하지 않음 -> 4.2mm, 4.7mm 와 같은 결과가 나올 수 있고 반올림 등에 따라 4mm 라고 표기 될 수 있음
> nanoTime을 활용하자
