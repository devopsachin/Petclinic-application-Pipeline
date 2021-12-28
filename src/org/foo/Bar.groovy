package org.foo
class Bar implements Serializable {
  def steps
  Bar(steps) {this.steps = steps}
  def mvn(args) {
    steps.sh "${steps.tool /bin/mvn -o ${args}"
  }
}
