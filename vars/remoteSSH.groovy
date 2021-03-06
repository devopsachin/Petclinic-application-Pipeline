def ssh(def username, def ipAdr, def applicationName, def dockerRepo, def applicationPort){
    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
    sshagent (credentials: ['ssh-key']){
        sh """ssh -o StrictHostKeyChecking=no "${username}"@"${ipAdr}" """
        sh """ ssh "${username}"@"${ipAdr}" sudo docker login -u "${USERNAME}" --password="${PASSWORD}" """
        sh """ ssh "${username}"@"${ipAdr}" sudo docker stop "${applicationName}" || true """
        sh """ ssh "${username}"@"${ipAdr}" sudo docker rm "${applicationName}" || true """
        sh """ ssh "${username}"@"${ipAdr}" sudo docker pull "${dockerRepo}"/"${applicationName}":$BUILD_NUMBER """
        sh """ ssh "${username}"@"${ipAdr}" sudo docker run -it -d --name "${applicationName}" -p "${applicationPort}":"${applicationPort}" "${dockerRepo}"/"${applicationName}":$BUILD_NUMBER """
    }
}
}
