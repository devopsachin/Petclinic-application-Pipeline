def test(def projectkey){
    def scannerHome = tool 'sonarqube'
    withSonarQubeEnv('sonarqube'){
    sh "${scannerHome}/bin/sonar-scanner \
    -Dsonar.projectKey=${projectkey} \
        -Dsonar.working.directory= \
        -Dsonar.analysis.mode= \
      -Dsonar.exclusions=vendor/**,resources/**,**/*.java,.scannerwork/** " 
 }
 sh "sudo rm -rf ${WORKSPACE}/.scannerwork"
}
