package org.foo
class shell implements  Serializable{
  def steps
  shell (steps){
    this.steps = steps
  }
  def script(){
    steps.sh "sudo docker login --user username --password password"
  }
}
