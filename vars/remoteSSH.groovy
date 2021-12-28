def ssh(def username, def ipAdr){
    withCredentials([sshuserPrivateKey(credentialsId: 'ssh-key', keyFileVariable: 'keyfile')]){
        sh 'ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" '
    }
}
