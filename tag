pipeline{
        agent any 
        
        stages{
              stage('Build a tag'){
              when {
                    buildingTag()
                   }
                   steps{
                        echo "Building a specific tag"
                        }
                     }
                  }
              }
