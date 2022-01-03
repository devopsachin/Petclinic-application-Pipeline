class Utility implements Serializable {     /* Library class  Serializable=this is interface    (The process of writing the state of an object to a file is called) */
    def steps                               /* OBJECT */
    Utility(steps) {
        this.steps = steps                  /* This keyword is used to refer current object instance */
    }
    def dockerLogin(String credentials){     /* dockerLogin is a Method */
            this.steps.withCredentials([steps.usernamePassword(credentialsId: credentials, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )])   /* super class */
            {
                this.steps.sh "sudo docker login -u " + '${USERNAME}' + " --password " + '${PASSWORD}' + " "
            }
    }


   def dockerBuild(path, dockerRepoName, applicationName){                          /* dockerBuild is other method inside class utility */
        this.steps.sh "sudo docker build -f ${path}/Dockerfile -t ${dockerRepoName}/${applicationName} ."
    }
    def dockerPush(dockerRepoName, applicationName){                                /* dockerPush is other metod inside class utility */
      this.steps.sh "sudo docker push ${dockerRepoName}/${applicationName}"
    }

} 

