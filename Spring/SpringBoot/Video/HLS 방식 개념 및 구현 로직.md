# 1. 라이브 영상 스트리밍 가능한 프로토콜 ( RTMP, HLS, WebRTC 등 )

1. RTMP ( Real Time Message Protocol ) 
- HTML5 에서 지원이 되지 않고 Adobe Flash가 지원 종료 됨으로서 사장됨.

2. HLS ( Http Live Streaming , ABR ( Adaptive BitRate streaming 사용  ) ) 
- HTTP 기반 단방향 스트리밍 방식임
- HTML5을 위한 프로토콜로 개발됨. 물론 다른 것도 가능.
- HTTP 기반이므로 호환성이 매우 높음
- .ts 단위로 쪼개짐 ( ex : 4초 단위 세그먼트로 나누어짐. 이 때 장점이 생김. 유저는 매번 모든 영상을 다운받는 것이 아닌 필요한 부분만 다운로드하여 재생함 )
- .m3m8 ( 화질별로 구분지어짐 >> 네트워크 환경에 따라 저화질, 고화질로 유연한 변경이 가능 )

3. WebRTC ( Web Real-Time-Communication ) , ABR ( Adaptive BitRate streaming 사용  )
- p2p ( peer to peer ) 방식을 지원함 ( 쉽게 말하면 양방향 지원 )
- 지연시간이 낮음 
- 호환성이 좋음

# 2. 전체 Flow
1. 외부 기기로부터 JPEG ( or 다른 확장자도 가능 ) 를 byte[] 로 전달 받음 ( JSON 등의 형식으로 통신하기 때문에 문자열 방식이 유리하므로 Base64 인코딩도 파일의 손상 등을 방지하기 위해 권장됨 )
2. Spring Boot에서는 받은 프레임을 FFMPEG ( Fast-Forawrd MPEG ) 프로그램을 사용하여 인코딩 및 HLS 형식으로 변환해줌
3. 스케쥴러를 설정하여 일정 주기마다 실행 2번을 실행
4. FrontEnd에서는 http 기반의 특정 url로 접근하여 영상을 스트리밍
