def call (String command){
      stage ('Cleaning and Building repo'){
        steps{
        sh "mvn ${command} "
      }
      }
    }
