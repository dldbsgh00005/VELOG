# Threshold
- 이미지를 이진화(Binarization) 할 때 흑 / 백으로 나누는 임계값

## 예시
- pixel의 rgb단위는 0 ~ 255이고 (1개의 채널만을 써서 밝기 정보만 표시한다. GrayScale의 경우 흑 ~ 회색 ~ 백 사이의 구간만을 표시함)
- 0 ~ 255 사이의 값으로 표시한다.
- 이 떄 기준 값을 기준으로 흑 / 백처럼 분리하게 된다.
- RGB(0, 0, 0) -> 검은색
- RGB(128, 128, 128) -> 회색
- RGB(255, 255, 255) -> 흰색

# C# 코드 예시
<img width="757" height="33" alt="image" src="https://github.com/user-attachments/assets/b07e9bf4-1a72-46ef-9c31-8f83aebdc2a5" />

- 매개변수 1 : 원본 이미지 (src)
- 매개변수 2 : 결과 저장할 변수 (res)
- 매개변수 3 : 임계값 (threshold), 0이면 OTSU가 자동 처리
- 매개변수 4 : 조건 충족 시 줄 값 (예시에서는 255)
- 매개변수 5 : ThresholdTypes.Binary 는 흑/백 나누는 이진화 / ThresholdTypes.Otsu (이미지 픽셀 값의 히스토그램(밝기 분포)에서 **클래스 간 분산(Between-class variance)**이 최대가 되는 임계값을 찾음)
