pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/<your-name>/cicd-demo-app.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo "Sonar will be added later"
            }
        }

        stage('Docker Build') {
            steps {
                echo "Docker build will be added later"
            }
        }

        stage('Push to ECR') {
            steps {
                echo "ECR push will be added later"
            }
        }

        stage('Deploy via ArgoCD') {
            steps {
                echo "ArgoCD rollout will be added later"
            }
        }
    }
}
// test
