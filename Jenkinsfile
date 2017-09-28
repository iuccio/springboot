#!groovy

pipeline {
    agent any

    triggers {
        pollSCM('H/5 * * * *')
        cron('@midnight')
    }

    stages {

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

    post {
      // Always runs. And it runs before any of the other post conditions.
      always {
        // Wipe the workspace so we are building completely clean
        deleteDir();
      }

      success {
             echo 'Success....'
            //mail(from: "bob@example.com", to: "steve@example.com", subject: "That build passed.", body: "Nothing to see here")
      }

      failure {
             echo 'Failure....'
            //mail(from: "bob@example.com", to: "steve@example.com", subject: "That build failed!", body: "Nothing to see here")
      }
    }

    // The options directive is for configuration that applies to the whole job.
    options {
        // We'd like to make sure we only keep 10 builds at a time, so
        // we don't fill up our storage!
        buildDiscarder(logRotator(numToKeepStr:'5'))

        // And we'd really like to be sure that this build doesn't hang forever, so
        // let's time it out after an hour.
        timeout(time: 10, unit: 'MINUTES')
    }
}