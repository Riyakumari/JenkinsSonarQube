node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'Maven3';
    def scannerHome= tool 'SonarQube';
        withSonarQubeEnv('SonarQube') {
            sh "${scannerHome}/bin/sonar-scanner \
            -D sonar.login=admin \
            -D sonar.password=4Bufttc01j \
            -D sonar.projectkey=Project1 \
            -d sonar.exclusions=vendor/**,resources/**,**/*.java \
            -D sonar.host.url=http://localhost:9000/"
    }
  }
}
