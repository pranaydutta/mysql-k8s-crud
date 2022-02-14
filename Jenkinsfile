pipeline {
    agent any
    
   stages {
        stage('Example') {
            steps {
               bat "mvn clean test -Dsuite=SMOKE_TEST -Denvironment=QA"
            }
        }
    }
}
