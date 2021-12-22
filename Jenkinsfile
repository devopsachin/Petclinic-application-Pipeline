pipeline{
	agent any 
	
	stages{
		stage('buil main'){
			when{
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
