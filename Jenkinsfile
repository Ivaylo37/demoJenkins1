pipeline {
    agent any

    tools {
        maven 'Maven'  // This assumes you have Maven configured in Jenkins
        jdk 'JDK'  // This assumes you have JDK configured in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/TEST-*.xml'
        }
    }
}