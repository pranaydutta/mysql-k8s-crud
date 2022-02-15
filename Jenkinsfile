currentBuild.displayName="demo-#"+currentBuild.number

pipeline {
    agent any
	environment
	{	
		COMMIT_ID=$('git rev-parse' --verify HEAD)
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
	 
            steps {
                bat 'mvn install' 
            }
	    
    }
        
         
    
    
	
	stage('Build_Image')
	{
		//agent { dockerfile true }
		steps{
			script{
				echo "docker tag is : ${DOCKER_TAG}"
				bat 'docker build -t springboot-crud-k8s:${COMMIT_ID} .'
			}
		}
	}
	    
	    
	    stage('Push_Image')
	    {
		    steps{
		    script{	  
   			bat 'docker login -u pranay8032 -p pranay8032'
			bat 'docker push pranay8032/springboot-crud-k8s:latest'
			 // withCredentials([usernamePassword(credentialsId: 'docker_hub', passwordVariable: 'hubpwd', usernameVariable: 'hubuser')]) {
				//  echo "Hub username : ${hubpwd}"
				//  bat 'docker login -u ${hubuser} -p ${hubpwd}'
				
			//bat 'docker push pranay8032/springboot-crud-k8s:latest'
//}
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
   
}

def getDockerTag()
{
	def tag = bat script: 'git rev-parse HEAD', returnStdout: true
	echo "docker tag in getDockerTag: ${tag}"
	return tag
}
