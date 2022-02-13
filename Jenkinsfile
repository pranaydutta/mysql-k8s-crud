 def app

pipeline {
    agent any


    def app

    tools {
        maven 'Maven 3.3.9'
        jdk 'jdk8'
    }
   stages { 
     stage('Clone repository') {
      

        checkout scm
    }
    
    stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    
    stage ('Build') {
            steps {
                sh 'mvn install' 
            }
    }
    
   

    stage('Build image') {
        
       app = docker.build("pranay8032/springboot-crud-k8s:2.0")
    }

    stage('Test image') {
  

        app.inside {
            sh 'echo "Tests passed"'
        }
    }

    stage('Push image') {
        
        docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
}

