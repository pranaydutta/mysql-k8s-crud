pipeline {
   agent {
        docker {
            image 'maven:3.8.1-adoptopenjdk-11' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
   stages { 
     stage('Clone repository') {
       steps {

        checkout scm
       }
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
    
   
   }
   

}

