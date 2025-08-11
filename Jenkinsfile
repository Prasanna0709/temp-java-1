pipeline {
	
	agent any
	
	environment{
		IMAGE_NAME = "quarkus-example-deployment"
		CONTAINER_NAME = "quarkus-app"
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
				sh "docker build -t prasanna0218/${IMAGE_NAME}:${BUILD_NUMBER} ."
				echo 'docker Image is created !'
			}
		}
		
		stage('docker image push'){
			steps{
				echo 'Pushing the Docker Image to the Docker Hub !'
				sh "docker push prasanna0218/${IMAGE_NAME}:${BUILD_NUMBER}"
				echo 'Application image is pushed into the docker hub !'
			}
		}
		
		stage('docker pull'){
			steps{
				echo 'Docker image is pulled from the Docker hub !'
				sh "docker pull prasanna0218/${IMAGE_NAME}:${BUILD_NUMBER}"
			}
		}
		
		stage('Removing older Images'){
			steps{
				script{
					def Current_Build_Number = env.BUILD_NUMBER.toInteger()
					def Second_Older_Number = Current_Build_Number - 2
					
					if(Second_Older_Number > 0){
						echo "Older images found removing older images"
						sh "docker rmi prasanna0218/${IMAGE_NAME}:${Second_Older_Number} || true"
					}else{
						echo "No older images found , skipping removal od Images !"
					}
				}
			}
		}
		
		stage('docker stop container'){
			steps{
				script{
					try{
						sh "docker stop ${CONTAINER_NAME} || true"
						sh "docker rm ${CONTAINER_NAME} || true"
					}catch(err){
						echo "No containers found , skipping the container stop ..."
					}
					
					
					echo "Starting the Application as a container ...."
					sh "docker run -d --name ${CONTAINER_NAME} -p 8081:8081 prasanna0218/${IMAGE_NAME}:${BUILD_NUMBER}"
					echo "Container started .."
					echo "Application running successfully !"
				}
			}
		}
		
	}
	
}