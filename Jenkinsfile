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
                sh "git pull https://github.com/devopsachin/Petclinic-application-Pipeline.git"
                dir ('Petclinic-application-Pipeline'){
                sh "sudo docker build -t 3mmmm123/myname:$BUILD_NUMBER ."
                }
            }
        }
            stage ('Running Java Application'){
                steps{
                    dir ('spring-petclinic'){
                    sh "sudo nohup java -jar target/*.jar --server.port=8083 &"  
                    sh "sleep 15"
                    }
                }
            }
                    stage ('Validating'){
                        steps {
                        //get api response and pring of its 200 and send mail
                        sh "sudo ss -tulpn | grep LISTEN"
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
