pipeline {
    agent any
    stages {
        stage('git repo & clean') {
            steps {
                bat "git clone https://github.com/Riyakumari/JenkinsSonarQube.git"
                bat "mvn clean -f JenkinsSonarQube/sample-project-maven-master"
            }
        }
        stage('install') {
            steps {
                bat "mvn install -f JenkinsSonarQube/sample-project-maven-master"
            }
        }
        stage('test') {
            steps {
                bat "mvn test -f JenkinsSonarQube/sample-project-maven-master"
            }
        }
        stage('package') {
            steps {
                bat "mvn package -f JenkinsSonarQube/sample-project-maven-master"
            }
        }
    }
}
