pipeline {
	
	agent any
	
	tools {
        maven 'Maven-3.9.6' 
    }
	
	stages{
		
		stage ('Checkout code from git'){
			steps{
				checkout scm
			}
		}
		
		stage ('maven build'){
			steps{
				echo 'Building the Jar file from the Application code ...'
				sh 'mvn clean package'
				echo 'Jar file created !'
			}
		}
	}
	
}