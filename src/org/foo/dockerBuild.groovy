package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(String credentials){
      this.steps.withCredentials([steps.usernameColonPassword(credentialsId: credentials, variable: 'usernameVariable' )]){
        steps.echo "'${usernameVariable}'"
                                                              
        this.steps.sh "sudo docker login --username '${usernameVariable}' --password "
        steps.sh "sudo docker build -f ${path}/tomcatDockerfile -t ${dockerRepoName}/${applicationName} ."
        steps.sh "sudo docker push ${dockerRepoName}/${applicationName} "
      }
}
}
//, path, dockerRepoName, applicationName
//usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )]){
