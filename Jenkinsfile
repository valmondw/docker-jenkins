pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh for MAC
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh for MAC
                bat "docker build -t=valmondw/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhubid', passwordVariable: 'pass', usernameVariable: 'user')]) {
                //sh for MAC
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push valmondw/selenium-docker:latest"
			    }
            }
        }
		stage('Start Grid') {
            steps {
                //sh for MAC
                bat "docker-compose up -d hub chrome firefox"
            }
        }
		stage('Run Test') {
            steps {
                bat "docker-compose up bookflight-module_1 duckduck-module_1"
            }
        }
        stage('Stop Grid') {
            steps {
                bat "docker-compose down"
            }
        }
    }
}