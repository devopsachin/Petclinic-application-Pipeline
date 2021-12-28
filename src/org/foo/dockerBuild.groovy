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
            credentialsId: this.docoker-hub,
            variable: "unameColonPwd")
        ]){
  this.steps.sh """echo Hi"""
  //sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
 }
    return this;
  }
}
