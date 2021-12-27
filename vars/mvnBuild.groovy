def call (String command){
  pipeline {
      agent any 
    stages {
      stage ('Cleaning and Building repo'){
        steps{
        sh "mvn ${command} "
      }
      }
    }
  }
}
