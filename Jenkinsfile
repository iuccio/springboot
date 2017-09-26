pipeline {
    agent any
    stages {
        stage('Checkout'){
            steps {
               echo 'Checkout source code....'
               git url: "https://github.com/iuccio/springboot.git"
            }
        }
        stage('Test') {
            steps {
               echo 'Test....'
               sh "./gradlew clean test"
            }
        }
        stage('Build Docker') {
            steps {
                echo 'Build Docker....'
                sh "./gradlew build"
            }
        }
    }
}