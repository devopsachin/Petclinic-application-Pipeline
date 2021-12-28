def login (){
withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker-hub',
                    usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
  sh """sudo docker login --username="${USERNAME}" --password="${PASSWORD}" """
  }
}
def build(def path, def dockerRepoName, def applicationName){
  sh """ sudo docker build -f "${path}"/Dockerfile -t "${dockerRepoName}"/"${applicationName}" ."""
}
def push (def dockerRepoName, def applicationName){
  sh """ sudo docker push "${dockerRepoName}"/"${applicationName}" """
}
        
