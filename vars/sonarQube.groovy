def test(def projectkey){
    def scannerHome = tool 'sonarqube'
    withSonarQubeEnv('sonarqube'){
    sh "${scannerHome}/bin/sonar-scanner \
    -Dsonar.projectKey=${projectkey} \
    -Dsonar.buildbreaker.skip=true \
        -Dsonar.scanner.metadataFilePath=${WORKSPACE}/sonarQube \
         -Dsonar.exclusions=vendor/**,resources/**,**/*.java " 
 }
}
