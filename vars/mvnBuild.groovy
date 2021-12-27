def call (String command){
  pipeline {
      agent any 
    tools {
        maven 'Maven 3.5.0'
        jdk 'jdk8'
    }
    stages {
      stage ('Cleaning and Building repo'){
        steps{
        sh "mvn ${command} "
      }
      }
    }
  }
}
