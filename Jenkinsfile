pipeline {
    agent any
    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-hub')
	}
    def remote = [13.235.23.76]
    remote.name = 'Docker'
    remote.host = ec2-13-235-23-76.ap-south-1.compute.amazonaws.com
    remote.user = 'jenkins'
    remote.password = 'jenkins'
    remote.allowAnyHosts = true
    
    stages {
        stage('Cloning Repo') {
            steps {
               //sh  "git pull https://github.com/spring-projects/spring-petclinic.git"
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
        stage ('Building a container'){
            steps{
                sh "rm -rf Petclinic-application-Pipeline"
                sh "git clone https://github.com/devopsachin/Petclinic-application-Pipeline.git"
               
                sh "sudo docker build -f Petclinic-application-Pipeline/Dockerfile -t 3mmmm123/myname:$BUILD_NUMBER ."
                
            }
        }        
            stage ('Pushing Image into Docker regestry'){
                steps{
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                    sh "sudo docker push 3mmmm123/myname:$BUILD_NUMBER"
                }
            }
             stage ('Deplyoing in applicaton Server'){
                steps {
		    sshCommand remote, command: "docker pull 3mmmm123/myname:$BUILD_NUMBER"
		    sshCommand remote, command: "docker run -it 3mmmm123/myname:$BUILD_NUMBER"
                    //sh "ssh ubuntu@13.235.23.76 docker pull 3mmmm123/myname:$BUILD_NUMBER"
                    //sh "ssh ubuntu@13.235.23.76 docker run -it 3mmmm123/myname:$BUILD_NUMBER"
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
