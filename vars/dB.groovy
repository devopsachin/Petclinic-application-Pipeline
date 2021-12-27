def login (){
withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  sh """docker login --username: "${USERNAME} --password: "${PASSWORD}"
  }
  }
