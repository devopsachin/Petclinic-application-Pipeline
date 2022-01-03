class pet implements Serializable {
  def pipeline
  
  pet(pipeline){
    this.pipeline = pipeline 
  }
  def HelloWorld(args){
    pipeline.sh "Hello World "$args""
  }
}
  
