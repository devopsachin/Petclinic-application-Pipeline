class Utility implements Serializable {     /* Library class  Serializable=this is interface     */
    def steps
    Utility(steps) {
        this.steps = steps
    }
    def dockerLogin(String credentials){     /* dockerLogin is a Method */
      try {
            this.steps.withCredentials([steps.usernamePassword(credentialsId: credentials, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )])   /* super class */
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
        this.steps.sh "sudo docker build -f ${path}/Dockerfile -t ${dockerRepoName}/${applicationName} ."
    }
    def dockerPush(dockerRepoName, applicationName){
      this.steps.sh "sudo docker push ${dockerRepoName}/${applicationName}"
    }

} 

