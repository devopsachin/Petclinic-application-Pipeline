def ssh(def username, def ipAdr){
    sshagent (credentials: ['ssh-key']){
      sh 'ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" '
    }
}
def run(){
    sh ' uptime'
    sh 'whoami'
}
