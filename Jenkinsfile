node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Maven3';
    withSonarQubeEnv() {
      bat "${mvn} clean verify sonar:sonar \
  -Dsonar.projectKey=Pipeline_assn6 \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=2408eabd2643758ca15f69cf0636c2e933b45b56"
    }
  }
}
