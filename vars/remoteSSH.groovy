def ssh(def username, def ipAdr){
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
    sshagent (credentials: ['ssh-key']){
      sh """ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
        sh """ ssh "${username}"@"${ipAdr}" sudo docker login -u "${USERNAME}" --password="${PASSWORD}" """
    }
}
}
