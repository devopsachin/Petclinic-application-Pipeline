package org.foo
class exe implements  Serializable{
  def steps
  exe (steps){
    this.steps = steps
  }
  def script(){
    steps.sh "sudo docker login --user username --password password"
  }
}
return exe
