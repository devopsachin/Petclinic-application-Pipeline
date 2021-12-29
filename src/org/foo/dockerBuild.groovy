package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(args){
    
    steps.sh "sudo docker login"
    steps.sh "echo ${args}"
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
