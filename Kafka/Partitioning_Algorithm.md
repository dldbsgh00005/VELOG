Kafka는 key값의 유무에 따라 Partition 할당 방식 결정

key != null : hash(key) % Partition Count -> 동일한 key에 동일한 partition 분배 가능

key == null : Round Robin 알고리즘 적용

📘 Order Proof : key값을 동일하게
📘 동일 key 트래픽 폭주 시 : key#subKey 방식으로 분배
📘 월드컵 경기 등 채팅방 폭주 시 : 1 Producer => 1 Consumer 이므로 수직적 확장 필요
