package org.foo
class shell implements Serializable {
  def steps
  shell(steps) {this.steps = steps}
  def mvn(args) {
   // steps.sh "${steps.tool 'mvn'}/bin/mvn -o ${args}"
    steps.sh "sudo docker login --username ${args} --password mydocker2021"
  }
}

