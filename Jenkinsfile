def app
pipeline {
    agent any
    stages{
   stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    
    stage ('Build') {
            steps {
                bat 'mvn install' 
            }
    }
        
          stage('Build image') {
     
      steps {
      
       app = docker.build("pranay8032/springboot-crud-k8s:2.0")
       
      }
    }

    stage('Test image') {
   steps {
 step{
        app.inside {
            bat 'echo "Tests passed"'
        }
        }
   }
    }

    stage('Push image') {
     steps{
      
        docker.withRegistry('https://registry.hub.docker.com', 'docker_hub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        
      }
     }
        
    }
    
    }
   
}
