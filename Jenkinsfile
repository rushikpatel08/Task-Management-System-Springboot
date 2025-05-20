pipeline {
    agent any

    environment {
        EC2_USER = 'ec2-user'
        EC2_HOST = 'ec2-44-205-244-209.compute-1.amazonaws.com'
        APP_PATH = '/home/ec2-user/taskmanager-0.0.1-SANPSHOT.jar'
        REPO_URL = 'https://github.com/rushikpatel08/Task-Management-System-Springboot.git'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', url: "${REPO_URL}"
            }
        }

        stage('Build Spring Boot App') {
            steps {
                sh 'chmod +x mvnw'  
                sh './mvnw clean package -DskipTests'
            }
        }

         stage('Test Spring Boot App') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to EC2') {
            steps {
                sshagent(['ec2-key-pair']) {
                    sh "scp -o StrictHostKeyChecking=no target/taskmanager-0.0.1-SANPSHOT.jar ${EC2_USER}@${EC2_HOST}:${APP_PATH}"
                    sh "ssh -o StrictHostKeyChecking=no ${EC2_USER}@${EC2_HOST} 'nohup java -jar ${APP_PATH} > /dev/null 2>&1 &'"
                }
            }
        }

    }
}
