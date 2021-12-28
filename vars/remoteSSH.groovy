def ssh(def username, def ipAdr){
    withCredentials([sshUserPrivateKey(credentialsId: 'ssh-key')]){
        sh """ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
    }
}
