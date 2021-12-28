package org.foo

class dockerBuild impliments Serializable {
  def steps
  dockerBuild(steps) {this.steps = steps}
  def login (){
  withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  steps.sh """sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
  }
}
}
