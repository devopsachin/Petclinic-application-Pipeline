def ssh (def username, def ipAdr){
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'ssh-key',
                      usernameVariable: 'USERNAME' ]]){
      sh """ssh StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
    }
}
