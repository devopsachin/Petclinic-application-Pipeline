def ssh(def username, def ipAdr){
    sshagent (credentials: ['ssh-key']){
      sh """ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
      sh """ ssh "${username}"@"${ipAdr}" echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin """
    }
}
