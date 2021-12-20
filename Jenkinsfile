pipeline {
    agent any
    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub')
	}

  
  stages {
        stage('Pulling Code form repo') {
            steps {
		git credentialsId: 'github-creds', branch: 'main',
		url: 'https://github.com/devopsachin/Petclinic-application-Pipeline.git'
                dir ('spring-petclinic'){
                 	sh "pwd"
               }
            }
        } 
  
            stage('Building Code and testing'){
                steps{
                    dir ('spring-petclinic'){
                        sh "./mvnw package"
                    }
                }
            } 
	  stage ('Test'){
		  steps{
			  dir('spring-petclinic'){
				  sh './mvnw test'
			  }
		  }
		  post {
			  always{
				 junit 'spring-petclinic/target/surefire-reports/TEST-*.xml'

			  }
		  }
	  }
        stage ('Building a container'){
            steps{
                git credentialsId: 'github-creds', branch: 'main',
                url: 'https://github.com/devopsachin/Petclinic-application-Pipeline.git'
                sh "sudo docker build -f Petclinic-application-Pipeline/Dockerfile -t 3mmmm123/myname:$BUILD_NUMBER ."
                
            }
        }        
            stage ('Pushing Image into Docker regestry'){
                steps{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh "sudo docker push 3mmmm123/myname:$BUILD_NUMBER"
                }
            }
	
             stage ('Deplyoing'){
		     steps{
			//def pre_build_num = (env.$BUILD_NUMBER.toInteger()) - 1
			sshagent (credentials: ['ssh-key']) {
			   
   	  		   sh 'ssh -o StrictHostKeyChecking=no ubuntu@ec2-52-66-15-28.ap-south-1.compute.amazonaws.com echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
		           sh "ssh ubuntu@ec2-52-66-15-28.ap-south-1.compute.amazonaws.com sudo docker stop pet-clinic-${currentBuild.previousBuild.getNumber()}"
			   sh "ssh ubuntu@ec2-52-66-15-28.ap-south-1.compute.amazonaws.com sudo docker rm pet-clinic-${currentBuild.previousBuild.getNumber()}"
		           sh 'ssh -v ubuntu@ec2-52-66-15-28.ap-south-1.compute.amazonaws.com sudo docker pull 3mmmm123/myname:$BUILD_NUMBER'
			   sh 'ssh -v ubuntu@ec2-52-66-15-28.ap-south-1.compute.amazonaws.com sudo docker run -it -d --name pet-clinic-$BUILD_NUMBER -p 8080:8080 3mmmm123/myname:$BUILD_NUMBER'
                   		}
		     }
                    
    }   
}


     post {
           failure{
                        mail body: " App Deployment failed ${env.BUILD_URL}/console",
                        subject: "Build Failed for ${env.JOB_NAME} ",
                        to: "sachinur94@gmail.com"
                    }
                    success {
                        mail body: "App Deployment succsfull for full log click here ${env.BUILD_URL}/console",
                        subject: "Build Success for ${env.JOB_NAME}",
                        to: "sachinur94@gmail.com"
                    }
                }
}
