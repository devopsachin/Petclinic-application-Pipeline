package vars;
public class addBuild {
  def pipeline
  
  public SharedLibrary(pipeline) {
    pipeline.steps.echo(pipeline.getClass().toString())
    this.pipeline = pipeline
  }
  
  public void startBuild() {
    pipeline.steps.sh "echo 'Hello, World!'"
  }
}
