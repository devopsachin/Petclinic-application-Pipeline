def call (Map stageParams){
 path: [[dir: stageParams.path ]],
 command: [[cmd: stageParams.command ]]
 steps.sh("cd ${path}")
 steps.sh("./mvnw ${cmd}")
}
