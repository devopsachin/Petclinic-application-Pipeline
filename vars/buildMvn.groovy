def call (Map stageParams){
 sh ([
 path: [[dir: stageParams.path ]],
 command: [[cmd: stageParams.command ]]
 steps.sh("cd ${path}")
 steps.sh("./mvnw ${cmd}")
  ])
}
