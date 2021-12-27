pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                echo 'test pipeline'
                git branch: '${branch}', url: 'https://github.com/surbanik/automationPractice.git'
                bat 'mvn clean compile'
                echo 'Compiling Ok'
            }
        }
        stage('Test') {
            steps {
                bat "mvn -DEnv_Val=${Env_Val} clean test"
                echo "Test completed"
            }
            post {
               always{
                junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }
    }
}
