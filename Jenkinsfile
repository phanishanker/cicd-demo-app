pipeline {
    agent any

    stages {
        stage('Clone') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/<your-username>/cicd-demo-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'echo "Building application..."'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Running tests..."'
            }
        }

        stage('Package') {
            steps {
                sh 'echo "Packaging..."'
            }
        }
    }
    post {
        success {
            echo "Pipeline completed successfully!"
        }
    }
}
