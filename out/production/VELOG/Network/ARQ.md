# ARQ 개념
**ARQ(Automatic Repeat reQuest**) : 데이터 통신간 손실된 Segment 재전송 방법

# ARQ List
- **Go-Back-N ARQ** : 손실 발생 Segment 이후 모든 Segment 전송 -> 비효율적, 하지만 구현이 상대적 용이. <br>
- **Selective-Repeat ARQ**: SACK 정보 기반 손실된 Segment만 재전송 최대 3회, 이후 **RTO(Rtransmission TimeOut)** 으로 간주, 손실 처리

# 예시 
```
조건 : MSS(Maximum Segment Size) = 500 
상황 : Segment 1000, 1500, 2000, 2500을 보내야 함
Sender ----- Segment(1000), Segment(2000), Segment(2500) ----> Receiver     // Sender가 Segement 1000,2000,2500을 Receiver에게 전송 (1500누락) 
Receiver --- ACK(1000,2000,2500) + SACK(1500)  -> Sender                    // Receiver가 MSS=500 확인 후, 1500누락 감지, Sender에게 ACK(1000,2000,2500)과 SACK(1500) 전송
Sender --- Segment(1500) ---> Receiver                                      // Sender가 SACK(1500) 확인 후 Receiver에게 Segment(1500) 재전송
```
