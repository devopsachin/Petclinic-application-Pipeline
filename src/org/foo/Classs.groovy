class pet implements Serializable {         //Class Name is pet
  def pipeline                              // defining ibject 
  
  pet(pipeline){                            //assigning class into object 
    this.pipeline = pipeline                //refering pipeline object using this "keyword"
  }
  def HelloWorld(args){                     //Helloworld is method 
    pipeline.sh "echo Hello World ${args}"      // using object calling super class 
  }
}
  
