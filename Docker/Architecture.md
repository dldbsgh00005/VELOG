# Docker Architecture

- Docker Client : 명령어를 실행하는 곳
  
- Docker Host : 명령을 전달받아 실제로 동작 하는 곳  
  - Docker Daemon : Client의 명령을 전달받아 동작하는 주체 이미지 빌드 명령어 등
  - Image : 컨테이너를 만들기 위한 설정들이 세팅 된 것 ( 설계도 ) 
  - Container; 이미지의 인스턴스 ( 설계도로 실제로 만들어진 것 )
- Docker Docker Registry : 이미지, 확장 프로그램, 플러그인 등을 모아둔 저장소 (깃허브와 유사)
  - Images
  - Extensions
  - Plugins

# docker hub
- docker에서 운영하는 public 레지스트리
- private registry를 1개 생성 가능 ( 무료 기준 ) 

# 자체 제작 서버
- localhost 등에 생성하는 레지스트리 ( 자유도 높음, 무제한 생성 가능 )
