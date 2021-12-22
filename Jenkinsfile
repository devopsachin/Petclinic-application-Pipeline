pipeline{
	anent any 
	
	stages{
		stage('buil main'){
			enviornment{
				branch 'main'
			}
			steps{
				echo "Building main"
			}
		}

	stage('Bulding vaccine'){
		when {
			branch 'vaccine'
		}
		steps{
			echo "build vaccine"
		}
	}
 }
}
