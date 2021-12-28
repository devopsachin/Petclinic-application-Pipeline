package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(){
  this.step.withCredentials(
      binding: [
        this.steps.usernameColonPassword(
            credentialsId: this.credentialsId,
            variable: "docker-hub")
        ])
    {
  this.steps.sh "echo ${this.steps.env.unameColonPwd}"
  //sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
 }
  }
}
