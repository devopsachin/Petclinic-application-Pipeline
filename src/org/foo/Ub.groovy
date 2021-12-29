class U implements Serializable {
    def steps
    U(steps) {
        this.steps = steps
    }
    def doArchiveToNexus(String credentials){
        try {
            this.steps.withCredentials([steps.usernameColonPassword(credentialsId: credentials, variable: 'JENKINS_USER')]) {
                this.steps.sh "sudo docker login --user '${JENKINS_USER}'"
            }
        } catch (error){
            this.steps.echo error.getMessage()
            throw error
        }
    }
}
