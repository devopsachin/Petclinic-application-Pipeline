def call (Map stageParams){
 path: [[dir: stageParams.path ]],
 command: [[cmd: stageParams.command]]
 sh ('''cd $path && ./mvnw $command''')  
}
