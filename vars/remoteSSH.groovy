def ssh(def username, def ipAdr){
    withCredentials([sshUserPrivateKey(credentialsId: 'ssh-key', keyFileVariable: 'keyfile')]){
      sh """ssh StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
    }
}
