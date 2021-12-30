def test(def projectkey){
    def scannerHome = tool 'sonarqube'
    withSonarQubeEnv('sonarqube'){
    sh "${scannerHome}/bin/sonar-scanner \
    -Dsonar.projectKey=${projectkey} \
        -Dsonar.working.directory=${WORKSPACE}@tmp/ \
      -Dsonar.exclusions=vendor/**,resources/**,**/*.java " 
 }
}
