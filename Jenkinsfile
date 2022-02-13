pipeline {
    agent {
        docker { image 'mysql-k8s-crud:1.0' }
    }
    stages {
        stage('Test') {
            steps {
                sh 'mvn install'
            }
        }
    }
}
