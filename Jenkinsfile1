pipeline{

	agent any

	environment {
		DOCKERHUB_CREDENTIALS=credentials('docker_hub')
	}

	stages {

		stage('Build') {

			steps {
				sh 'docker build -t pranay8032/springboot-crud-k8s:2.0 .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push pranay8032/springboot-crud-k8s:2.0'
			}
		}
	}

	post {
		always {
			sh 'docker logout'
		}
	}

}
