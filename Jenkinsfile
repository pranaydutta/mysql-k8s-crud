pipeline {
    agent any
	
	options { buildDiscarder(logRotator(numToKeepStr: '5'))
		retry(3)
		}
	
	parameters {
string(name: 'USER', defaultValue: 'Muskan', description: 'A user that triggers the pipeline')
}

    stages{
   stage ('Initialize') {
            steps {
		    
		    echo "Pipeline triggered by ${params.USER}"
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }
    
    stage ('Build') {
        
        input{
		message "Press Ok to continue"
		submitter "user1,user2"
		parameters {
			string(name:'username', defaultValue: 'user', description: 'Username of the user pressing Ok')
		}
	}
	    withEnv(['MAVEN_OPTS=-xMS256M -xMX512M -XX:MaxPermSize=512m']){
            steps {
                bat 'mvn install' 
            }
	    }
    }
        
         
    
    
	
	stage('push')
	{
		agent{
			dockerfile true 
		}
		steps{
			
			bat 'docker images'
		}
	}
	    
    }
	
	post {
always {
	echo "pipeline finished"
	//bat ./performCleanUp.bat
}
}
   
}
