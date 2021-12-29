package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(){
    
  steps.sh "sudo docker login --username="${USERNAME}" --password="${PASSWORD}" "
 }
  }
//}

/*
this.step.withCredentials([
        usernamePassword(
            credentialsId: 'docker-hub',
            usernameVariable: 'USERNAME',
            passwordVariable: 'PASSWORD')
        ]){  */
