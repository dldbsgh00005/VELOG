pipeline {
    agent any

    environment {
        // 예시: Docker Hub 사용자명과 이미지명
        DOCKER_IMAGE = "your-dockerhub-username/yourapp:latest"
        // EC2 접속 정보 (Jenkins Credentials에 등록한 ID를 참조)
        EC2_HOST = "ec2-xx-xx-xx-xx.compute-1.amazonaws.com"
        SSH_CREDENTIALS_ID = "ec2-ssh-key"
        // Docker Hub 자격증명 (Credentials ID)
        DOCKER_CREDENTIALS_ID = "docker-hub-credentials"
    }

    stages {

        stage('Checkout') {
            steps {
                git url: 'https://your.git.repo/yourapp.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Maven/Gradle 빌드 (Maven 예제)
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker Image') {
            steps {
                // Docker 이미지 빌드
                script {
                    docker.build("${DOCKER_IMAGE}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                // Docker Hub에 이미지 푸시 (등록된 Docker Hub Credentials 사용)
                script {
                    docker.withRegistry('https://index.docker.io/v1/', "${DOCKER_CREDENTIALS_ID}") {
                        def appImage = docker.image("${DOCKER_IMAGE}")
                        appImage.push()
                    }
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                // EC2 인스턴스에 SSH로 접속하여 컨테이너 실행
                // 예시: 기존 컨테이너 종료 후 이미지 Pull 및 실행
                script {
                    def remoteCommand = """
                        docker stop yourapp-container || true
                        docker rm yourapp-container || true
                        docker pull ${DOCKER_IMAGE}
                        docker run -d -p 8080:8080 --name yourapp-container ${DOCKER_IMAGE}
                    """
                    // SSH Plugin을 이용해 EC2에 접속 (sshagent 사용)
                    sshagent([env.SSH_CREDENTIALS_ID]) {
                        sh "ssh -o StrictHostKeyChecking=no ubuntu@${env.EC2_HOST} '${remoteCommand}'"
                    }
                }
            }
        }
    }

    post {
        success {
            echo '배포 성공!'
        }
        failure {
            echo '배포 실패!'
        }
    }
}
