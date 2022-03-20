pipeline {
    agent any 
    stages {
        stage('Compile Stage') { 
            steps {
              withMaven(maven:'Maven3'){
                sh 'mvn clean compile'
              }
            }
        }
        stage('Deploy') { 
            steps {
              withMaven(maven:'Maven3'){
                sh 'mvn deploy'
            }
        }
    }
}
