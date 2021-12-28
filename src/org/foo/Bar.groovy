package org.foo
class Bar implements Serializable {
  def steps
  Bar(steps) {this.steps = steps}
  def mvn(args) {
    steps.sh "${steps.tool 'Maven'}/bin/mvn -o ${args}"
  }
}
