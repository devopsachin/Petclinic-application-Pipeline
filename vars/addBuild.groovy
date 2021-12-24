def call (String path = 'none'){
    sh "cd ${path}",
    sh "./mvnw package"
}
