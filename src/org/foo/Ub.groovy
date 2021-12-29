class U implements Serializable {
    def steps
    U(steps) {
        this.steps = steps
    }
    def doArchiveToNexus(String credentials){
        try {
            this.steps.withCredentials([steps.usernamePassword(credentialsId: credentials, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )]) {
              //  this.steps.echo " + '${JENKINS_USER}' + "
               // this.steps.sh "sudo docker login --username " + '${USERNAME}' + " --password " + '${PASSWORD}' + " "
                this.steps.sh "sudo docker login --username '${USERNAME}' --password '${PASSWORD}' "
            }
        } catch (error){
            this.steps.echo error.getMessage()
            throw error
        }
    }
}
