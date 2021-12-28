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
            variable: "unameColonPwd")
        ]){
  this.steps.sh """echo Hi"""
  //sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
 }
  }
}
