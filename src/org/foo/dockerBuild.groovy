package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(path, dockerRepoName, applicationName, USERNAME, PASSWORD){
    steps.sh "sudo docker login --user $USERNAME --password $PASSWORD"
    steps.sh "sudo docker build -f ${path}/Dockerfile -t ${dockerRepoName}/${applicationName} ."
    steps.sh "sudo docker push ${dockerRepoName}/${applicationName} "
      }
}
