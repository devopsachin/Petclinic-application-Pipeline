pipeline{
	anent any 
	
	stages{
		stage('buil main'){
			enviornment{
				branch 'prod'
			}
			steps{
				echo "Building prod"
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
