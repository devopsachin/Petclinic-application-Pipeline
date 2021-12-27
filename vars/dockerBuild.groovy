def login (){
withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  sh """sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
  }
}
def build(def path, def tag){
  sh """ sudo docker build -f "${path}"/Dockerfile -t "${tag}" ."""
}
def push (String tag){
  sh """ sudo docker push "${tag}" """
}
        
