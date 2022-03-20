node {
  stage('SCM') {
    git 'https://github.com/Riyakumari/JenkinsSonarQube.git'
  }
  stage('SonarQube analysis') {
    withSonarQubeEnv(credentialsId: 'ea52027c-3d8a-4cde-92e9-d012926a03a8', installationName: 'SonarQube') { // You can override the credential to be used
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
    }
  }
}
