def ssh(def username, def ipAdr){
    withCredentials([[$class: 'ssh-agent', credentialsId: 'ssh-key',
                      usernameVariable: 'USERNAME' ]]){
      sh """ssh StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
    }
}
