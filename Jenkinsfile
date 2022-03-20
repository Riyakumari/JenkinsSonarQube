pipeline {
    agent any 
    def mvn = tool 'Maven3';
    stages {
        stage('Compile Stage') { 
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Deployment Stage') { 
            steps {
                sh 'mvn deploy'
            }
        }
    }
}
