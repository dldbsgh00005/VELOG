## 개념
Amoltaized(아몰타이즈) : 전체적인 값이 불일정할 때 평균치로 계산하는 것.

## 예시
Array 중간 삽입 시 Base Address + 1 인덱스와 length-1 인덱스 삽입의 차이는 있지만 평균치는 상수 (length/2)
> Array 크기 조정으로 인한 O(N)이 추가됨, 하지만 tail에 값 삽입 시 O(1) ... 평균치 O(1)에 수렴
