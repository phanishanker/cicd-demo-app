pipeline {
    agent any

    environment {
        ECR_REGISTRY = "120935945180.dkr.ecr.ap-southeast-1.amazonaws.com"
        ECR_REPO = "cicd-demo-app"
        AWS_REGION = "ap-southeast-1"
    }

    tools {
        maven 'Maven3'
        jdk 'JDK17'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/phanishanker/cicd-demo-app.git'
            }
        }

        stage('Build App') {
            steps {
                sh 'mvn clean install -DskipTests=false'
            }
        }

        stage('Docker Build') {
            steps {
                script {
                    sh """
                    docker build -t ${ECR_REPO}:latest .
                    """
                }
            }
        }

        stage('ECR Login') {
            steps {
                withAWS(credentials: 'aws-ecr-creds', region: "${AWS_REGION}") {
                    sh """
                    aws ecr get-login-password --region ${AWS_REGION} | \
                    docker login --username AWS --password-stdin ${ECR_REGISTRY}
                    """
                }
            }
        }

        stage('Tag & Push Image') {
            steps {
                script {
                    def imageTag = sh(script: "date +%Y%m%d%H%M%S", returnStdout: true).trim()

                    sh """
                    docker tag ${ECR_REPO}:latest ${ECR_REGISTRY}/${ECR_REPO}:${imageTag}
                    docker tag ${ECR_REPO}:latest ${ECR_REGISTRY}/${ECR_REPO}:latest

                    docker push ${ECR_REGISTRY}/${ECR_REPO}:${imageTag}
                    docker push ${ECR_REGISTRY}/${ECR_REPO}:latest
                    """
                }
            }
        }

    }

    post {
        success {
            echo "Build + Docker Push completed successfully."
        }
        failure {
            echo "Pipeline failed."
        }
    }
}
//test
