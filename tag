pipeline{
        agent any 
        
        stages{
              stage('Build a tag'){
              when {
                    bulidingTag()
                   }
                   steps{
                        echo "Building a specific tag"
                        }
                     }
                  }
              }
