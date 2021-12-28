def ssh(def username, def ipAdr){
    withCredentials([sshUserPrivateKey(credentialsId: 'ssh-key', keyFileVariable: 'keyfile')]){
        sh """ssh -i ${keyfile} -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
    }
}
