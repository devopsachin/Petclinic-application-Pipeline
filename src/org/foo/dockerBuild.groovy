package org.foo

class dockerBuild implements Serializable {
  def steps
  dockerBuild(steps) {this.steps = steps}
  def login (){
  withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  steps.sh """ docker login --username=admin --password= """
  //sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
  }
}
  
}
