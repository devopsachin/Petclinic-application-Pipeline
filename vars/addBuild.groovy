def call (String path = 'none'){
    echo "cd ${path}",
    echo "./mvnw package"
}
