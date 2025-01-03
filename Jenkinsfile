pipeline {
    agent any

    tools {
        maven 'sonarmaven'
    }

    environment {
        SONARQUBE_SERVER = 'sonarqube'
        SONAR_TOKEN = credentials('sonar-token')  
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat '''
                mvn clean install
                '''
            }
        }

        stage('Test') {
            steps {
                bat '''
                mvn test
                '''
            }
        }

        stage('SonarAnalysis') {
            environment {
                SONAR_TOKEN = credentials('sonar-token') // Accessing the SonarQube token stored in Jenkins credentials
            }
            steps {
                bat '''
                mvn clean verify sonar:sonar \
               -Dsonar.projectKey=t7 \
               -Dsonar.projectName="t7" \
               -Dsonar.host.url=http://localhost:9000 \
               -Dsonar.sources=. \
               -Dsonar.token=${SONAR_TOKEN}
                '''
            }
        }
    }

    post {
        success {
            echo "Successfully executed"
        }
        failure {
            echo "Did not work"
        }
    }
}
