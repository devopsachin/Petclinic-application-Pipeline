class Kubernetes implements Serializable  {
  def deploy 
  
  Kubernetes(deploy){
    this.deploy = deploy
  }
  
  
  def clean(deploymentFile, serviceFile, path){
    deploy.sh "sudo kubectl delete -f ${path}/${deploymentFile} "
    deploy.sh "sudo kubectl delete -f ${path}/${serviceFile}"
  }
}
