def login (){
withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  sh """sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
  }
}
def build(String tag){
    sh """ sudo docker build -f Dockerfile -t "${tag}" ."""
}

        
