node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Maven3';
    withSonarQubeEnv() {
      bat "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=Pipeline-TestProj2"
    }
  }
}
