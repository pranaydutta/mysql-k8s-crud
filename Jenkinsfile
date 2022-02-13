pipeline {
    agent any
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

