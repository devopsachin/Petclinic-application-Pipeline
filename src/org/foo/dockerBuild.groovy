package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(){
    this.step.withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD')
        ]){
  this.steps.sh """echo $PASSWOR, "${env.USERNAME} """
    steps.sh "echo Myname"
  //sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
 }
  }
}
