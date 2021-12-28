def ssh(def username, def ipAdr){
    sshagent (credentials: ['ssh-key']){
      sh 'ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" '
    }
}
    //withCredentials([sshuserPrivateKey(credentialsId: 'ssh-key', keyFileVariable: 'keyfile')]){
        
   // }
//}
