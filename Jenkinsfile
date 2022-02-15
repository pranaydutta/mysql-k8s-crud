currentBuild.displayName="demo-#"+currentBuild.number

pipeline {
    agent any
	
	environment{
		COMMIT_ID = getDockerTag()
	}
	options { buildDiscarder(logRotator(numToKeepStr: '5'))
		//retry(1)
		}
	
	parameters {
string(name: 'USER', defaultValue: 'Muskan', description: 'A user that triggers the pipeline')
}

    stages{
   stage ('Initialize') {
            steps {
		    
		    echo "Pipeline triggered by ${params.USER}"
                sh '''
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
	 
            steps {
                sh 'mvn install' 
            }
	    
    }
        
         
    
    
	
	stage('Build_Image')
	{
		//agent { dockerfile true }
		steps{
			script{
				
				COMMIT_ID = getDockerTag()
				echo "COMMIT_ID is : ${COMMIT_ID}"
				sh 'docker build -t springboot-crud-k8s:${COMMIT_ID} .'
			}
			
		}
	}
	    
	    
	    stage('Push_Image')
	    {
		    steps{
		    script{	  
   			//sh 'docker login -u pranay8032 -p pranay8032'
			//sh 'docker push pranay8032/springboot-crud-k8s:latest'
			  withCredentials([usernamePassword(credentialsId: 'docker_hub', passwordVariable: 'hubpwd', usernameVariable: 'hubuser')]) {
				  echo "Hub username : ${hubpwd}"
				 sh 'docker login -u ${hubuser} -p ${hubpwd}'
				
			sh 'docker push pranay8032/springboot-crud-k8s:latest'
}
		    }
			    
}
		    }
	    
    }    
    
	
	post {
always {
	echo "pipeline finished"
	//bat ./performCleanUp.bat
}
}
   


def getDockerTag()
{
	def tag  =  sh script: 'git rev-parse --verify HEAD', returnStdout: true
	return tag
}
