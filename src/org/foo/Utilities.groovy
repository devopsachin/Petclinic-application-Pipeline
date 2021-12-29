package org.foo

class Utilities implements Serializable {
def steps
    Utilities(steps){    
    this.steps = steps
}
def login() {
    this.steps.withCredentials(
            bindings: [
                this.steps.usernameColonPassword(
                    credentialsId: this.docker-hub, 
                    variable: "unameColonPwd")
            ]) {
        this.steps.sh "echo {this.steps.env.unameColonPwd}"
    }
}
}
