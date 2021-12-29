package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {
    this.steps = steps
  }
  def login(path, dockerRepoName, applicationName){
    
    steps.sh "sudo docker login"
    steps.sh "sudo docker build -f ${path}/Dockerfile -t ${dockerRepoName}/${applicationName} ${path}"
    steps.sh "sudo docker push ${dockerRepoName}/${applicationName} "
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
