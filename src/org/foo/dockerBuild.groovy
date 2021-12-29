package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(String credentials){
    try{
      this.steps.withCredentials([steps.usernameColonPassword(credentialsId: credentials, variable: 'docker-hub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD', )]){
        steps.sh "sudo docker login --username '${USERNAME}' --password '${PASSWORD}'"
        }
      }catch (error){
            this.steps.echo error.getMessage()
            throw error
        }
        steps.sh "sudo docker build -f ${path}/Dockerfile -t ${dockerRepoName}/${applicationName} ."
        steps.sh "sudo docker push ${dockerRepoName}/${applicationName} "
      }
}
//, path, dockerRepoName, applicationName
