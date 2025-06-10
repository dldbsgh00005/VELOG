name: CI / CD Pipeline

# main 브랜치 push or pull_request를 트리거로 동작
on:
  push:
    branches: [ "main" ]  
  pull_request:
    branches: [ "main" ]

# 환경 변수 / Private Repository 이므로 단순 경로 등은 하드코딩 상수 처리 / EC2 관련 변수는 secrets 처리
env:
  # yml 
  localhost: localhost # (application.yml)
  
  # EC2 
  EC2_HOST: ${{secrets.EC2_HOST}} 
  EC2_USER: ${{secrets.EC2_USER}} 
  EC2_KEY: ${{secrets.EC2_KEY}} # EC2 Private Key
  
  # Path
  ROOT_PATH: /home/runner/work/[Repository_Name]
  PEM_KEY_PATH: /home/runner/work/[Repository_Name]/[Repository_Name]/key.pem
  PROJECT_PATH: /home/runner/work/[Repository_Name]/[Repository_Name]/lucid
  BUILD_PATH: /home/runner/work/[Repository_Name]/[Repository_Name]/lucid/build/libs
  JAR_PATH: /home/runner/work/[Repository_Name]/[Repository_Name]/lucid/build/libs/lucid.jar

# 실행 되는 jobs
jobs: 
  # 빌드 job
  build: 
    runs-on: ubuntu-latest # 우분투 최신 버전 사용
    permissions:
      contents: read 

    steps:
    - uses: actions/checkout@v4 
    - name: Set up JDK 21 # 프로젝트 JDK 버전과 호환   
      uses: actions/setup-java@v4
      with:
        java-version: '21'
        distribution: 'temurin'

    # 빌드 도구 설정
    - name: Setup Gradle
      uses: gradle/actions/setup-gradle@af1da67850ed9a4cedd57bfd976089dd991e2582 # v4.0.0
      with:
          # gradle-version: '8.8' # 현재 프로젝트 Gradle 버전
          cache-disabled: true       # 캐싱 비활성화 
          cache-cleanup: none        # 캐싱을 하지 않기 때문에 cleanup 동작 불필요

    # 빌드 
    - name: Gradle Build
      # 실행할 동작 
      # 현재 디렉토리 탐색 / 경로 이동 / gradle 권한 부여 / 현재 작업 디렉토리 경로 출력 / 빌드 실행, 테스트 진행 하지 않음, 빌드 실행 과정중 info 단계에 해당하는 로그 출력, debug, stacktrace 등 자세한 옵션 가능 
      run: |
        ls && cd $PROJECT_PATH && chmod +x gradlew 
        pwd && ./gradlew clean build -x test --info 

    # ec2 배포
    - name: Deploy to EC2 
      run: |
        echo 현재 위치 확인
        pwd
        echo PEM 키 생성하기
        echo "$EC2_KEY" > $PEM_KEY_PATH  
        echo pem키 생성 후 현재 위치 확인
        pwd
        echo pem키 생성 후 현재 디렉토리 파일 확인
        ls
        # PEM KEY 권한 설정
        chmod 600 $PEM_KEY_PATH 
        # Transfer files to EC2
        echo scp 시작 
        ls $BUILD_PATH
        # 병렬전송
        rsync --info=progress2 -e "ssh -i key.pem -o StrictHostKeyChecking=no" \
        $JAR_PATH $EC2_USER@$EC2_HOST:/home/ubuntu/ 
        
        # SSH into EC2 and restart the application  
        ssh -i $PEM_KEY_PATH $EC2_USER@$EC2_HOST << 'EOF'
          # 기존 프로세스 중지
          pkill -f 'java -jar' || true
          # 신규 프로세스 실행 ( cat nohup.out 명령어로 로그 확인 )
          nohup java -jar lucid.jar > /dev/null 2>&1 &
          exit
        EOF
        # 임시 생성 된 PEM KEY 삭제
        rm -f $PEM_KEY_PATH
        
