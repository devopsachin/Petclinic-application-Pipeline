def test(String project-key){
    def scanerhome = tool 'sonarqube'
    withSonarQubeEnv('sonarqube')
    sh "${scannerHome}/bin/sonar-scanner \
         -Dsonar.projectKey=pet-clinic \
         -Dsonar.exclusions=vendor/**,resources/**,**/*.java " 
 }
