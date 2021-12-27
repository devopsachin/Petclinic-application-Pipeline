def login (){
withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  sh """sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
  }
}
def build(def tag, def path){
  sh """ sudo docker build -f ${path}/Dockerfile -t "${tag}" ."""
}

        
