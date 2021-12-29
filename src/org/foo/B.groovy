class U implements Serializable {
    def steps
    U(steps) {
        this.steps = steps
    }
    def dockerLogin(String credentials){
      try {
            this.steps.withCredentials([steps.usernamePassword(credentialsId: credentials, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )]) 
            {
                this.steps.sh "sudo docker login -u " + '${USERNAME}' + " --password " + '${PASSWORD}' + " "
            }
     } 
       catch (error){
           this.steps.echo error.getMessage()
           throw error
     }
    }

   def dockerBuild(path, dockerRepoName, applicationName){
        this.steps.sh "docker build -f ${path}/Dockerfile -t ${dockerRepoName}/${applicationName} ."
    }
    def dockerPush(path, dockerRepoName, applicationName){
        this.steps.sh "docker push ${dockerRepoName}/${applicationName}"
    }
        
} 
