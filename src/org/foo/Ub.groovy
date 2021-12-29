class U implements Serializable {
    def steps
    U(steps) {
        this.steps = steps
    }
    def doArchiveToNexus(String credentials){
        try {
            this.steps.withCredentials([steps.UsernamePasswordMultiBinding(credentialsId: credentials, usernameVariable: 'JENKINS_USER', passwordVariable: 'JENKINS_PASSWORD' )]) {
                this.steps.echo " + '${JENKINS_USER}' + "
                this.steps.sh "sudo docker login --username " + '${JENKINS_USER}' + " --password " + '${JENKINS_PASSWORD}' + " "
            }
        } catch (error){
            this.steps.echo error.getMessage()
            throw error
        }
    }
}
