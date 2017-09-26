pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               sh 'java -version'
               sh 'gradle --version'
               sh 'gradle -version'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}