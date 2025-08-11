pipeline {
	
	agent any
	
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
		
		stage('docker image build'){
			steps{
				echo 'Building the docker image using the JAR file'
				sh 'docker build -t prasanna0218/${IMAGE_NAME}:${BUILD_NUMBER}'
				echo 'docker Image is created !'
			}
		}
		
	}
	
}