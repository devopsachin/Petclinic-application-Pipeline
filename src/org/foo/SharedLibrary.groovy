package org.foo

public class SharedLibrary {
  def pipeline
  
  public SharedLibrary(pipeline) {
    pipeline.steps.echo(pipeline.getClass().toString())
    this.pipeline = pipeline
  }
  
  public void startBuild() {
      this.pipeline.withCredentials([this.pipeline.usernamePassword(credentialsId: credentials, usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD' )]) 
            {
          this.pipeline.sh "sudo docker login -u " + '${USERNAME}' + " --password " + '${PASSWORD}' + " "
            }
    }

  }
