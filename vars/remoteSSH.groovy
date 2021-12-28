def ssh(def username, def ipAdr){
    withCredentials([sshagent(credentialsId: 'ssh-key', keyFileVariable: 'keyfile')]){
        sh 'ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" '
    }
}
