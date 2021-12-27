def login (){
    withCredentials(
    [
    usernamePassword(credentialsId: 'docker-hub', 
    usernameVarriable: 'dockeruser', 
    passwordVarriable: 'dockerpassword'
    )]){
      sh """docker login --username="${dockeruser}" --password="${dockerpassword}" """
   }
  }
