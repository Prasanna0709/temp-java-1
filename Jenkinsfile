pipeline {
	
	agent any
	
	environment{
		IMAGE_NAME = "quarkus-example-deployment"
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
		
		stage('docker login'){
			steps{
				withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',usernameVariable:'DOCKER_USERNAME',passwordVariable:'DOCKER_PASSWORD')]){
                        sh """
        					echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
    					"""
                }
			}
		}
		
		stage('docker image build'){
			steps{
				echo 'Building the docker image using the JAR file'
				sh 'docker build -t prasanna0218/${IMAGE_NAME}:${BUILD_NUMBER} .'
				echo 'docker Image is created !'
			}
		}
		
	}
	
}