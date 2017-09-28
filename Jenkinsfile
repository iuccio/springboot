pipeline {
    agent any
        //Wipe the workspace so we are building completely clean
        deleteDir()
    stages {

        stage('Checkout'){
            steps{
              checkout scm
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