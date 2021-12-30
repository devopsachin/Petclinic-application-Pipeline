def test(String projectkey){
    def scannerHome = tool 'sonarqube'
    withSonarQubeEnv('sonarqube'){
    sh "${scannerHome}/bin/sonar-scanner \
    -Dsonar.projectKey="${projectkey}" \
         -Dsonar.exclusions=vendor/**,resources/**,**/*.java " 
 }
}
