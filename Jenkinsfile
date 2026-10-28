pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    environment {
        STUDENT_NAME = 'Anarbek Ali'
        STUDENT_GROUP = 'IT2308'
        STUDENT_ID = '41505'
        IMAGE_NAME = 'anarbek-ali-student-api'
        IMAGE_TAG = 'v1.0-anarbek-ali'
    }

    stages {
        stage('Checkout') {
            steps {
                echo "===================================================="
                echo "Student: ${env.STUDENT_NAME} | Group: ${env.STUDENT_GROUP} | ID: ${env.STUDENT_ID}"
                echo "Stage 1: Retrieving source code from GitHub..."
                echo "===================================================="
                checkout scm
                sh 'git log -n 1 --oneline'
            }
        }

        stage('Build') {
            steps {
                echo "Stage 2: Compiling Spring Boot application for ${env.STUDENT_NAME}..."
                sh 'chmod +x ./gradlew'
                sh './gradlew compileJava compileTestJava --no-daemon'
            }
        }

        stage('Test') {
            steps {
                echo "Stage 3: Running automated JUnit tests for ${env.STUDENT_NAME}..."
                sh './gradlew test --no-daemon'
            }
        }

        stage('Docker Build') {
            steps {
                echo "Stage 4: Building personalized Docker image ${env.IMAGE_NAME}:${env.IMAGE_TAG}..."
                sh "docker build -t ${env.IMAGE_NAME}:${env.IMAGE_TAG} ."
            }
        }

        stage('Verify') {
            steps {
                echo "Stage 5: Verifying Docker image existence for ${env.STUDENT_NAME}..."
                sh "docker image inspect ${env.IMAGE_NAME}:${env.IMAGE_TAG} --format='Verified Image: {{.RepoTags}} | Size: {{.Size}} bytes'"
                sh "docker images ${env.IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo "SUCCESS: Pipeline for ${env.STUDENT_NAME} (${env.IMAGE_NAME}:${env.IMAGE_TAG}) completed successfully!"
        }
        failure {
            echo "FAILURE: Pipeline stopped due to an error in Build or Test stage for ${env.STUDENT_NAME}."
        }
    }
}
