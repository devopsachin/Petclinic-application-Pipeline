def ssh(def username, def ipAdr){
    withCredentials([sshUserPrivateKey(credentialsId: 'ssh-key', keyFileVariable: 'keyfile')]){
      sh """ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
    }
}
