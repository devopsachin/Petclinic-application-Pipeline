def call (String path = 'none'){
    sh "cd ${path}",
    eh "./mvnw package"
}
