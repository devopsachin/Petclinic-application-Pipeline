pipeline {
    agent any
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
                    sh "docker push 3mmmm123/myname:$BUILD_NUMBER"
                }
            }
                    stage ('Deplyoing in applicaton Server'){
                        steps {
                            sh "ssh ubuntu@13.235.23.76 docker pull 3mmmm123/myname:$BUILD_NUMBER"
                            sh "ssh ubuntu@13.235.23.76 docker run -it 3mmmm123/myname:$BUILD_NUMBER"
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
