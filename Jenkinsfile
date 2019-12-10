pipeline {
    // master executor should be set to 0
    agent any
    stages {
		stage('Pull Image') {
            steps {
                //sh for MAC
                bat "docker pull valmondw/selenium-docker"
            }
        }
		stage('Start Grid') {
            steps {
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