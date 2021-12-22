pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                echo 'test pipeline'
                git branch: '${branch}', url: 'https://github.com/surbanik/automationPractice.git'
                bat 'mvn clean compile'
                echo 'Ok'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn clean test'
                echo 'Test completed'
            }

        }
    }
}
