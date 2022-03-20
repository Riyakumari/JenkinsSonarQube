pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "git clone https://github.com/Riyakumari/JenkinsSonarQube.git"
                bat "mvn clean -f JenkinsSonarQube"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f JenkinsSonarQube"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f JenkinsSonarQube"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f JenkinsSonarQube"
            }
        }
    }
}
