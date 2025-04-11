```

# Registry

- docker run -p [port]:[port] --name [registry name] [registry image name]
  - ex ) docker run -p 5000:5000 --name registry registry
  - ex ) docker run -p 6000:6000 --name my-registry registry:2

  - localhost:5000 번, 6000번에 레지스트리 생성

# registry에 이미지 push, pull
- docker push [registry경로]/[이미지 이름]:[태그]
- docker pull [registry경로]/[이미지 이름]:[태그]

```