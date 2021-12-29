class Utilities implements Serializable {
    def steps
    Utilities(steps) {
        this.steps = steps
    }
    def doArchiveToNexus(String credentials, String artifact, String artifact_registry_path){
        try {
            this.steps.withCredentials([steps.usernameColonPassword(credentialsId: credentials, variable: 'JENKINS_USER')]) {
                this.steps.sh "curl --user " + '${JENKINS_USER}' + " --upload-file ${artifact} ${artifact_registry_path}"
            }
        } catch (error){
            this.steps.echo error.getMessage()
            throw error
        }
    }
}
