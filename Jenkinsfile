pipeline {
    agent any
    
   stages {
        stage('Example') {
            steps {
               bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    }
}
