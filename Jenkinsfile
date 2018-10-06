pipeline {
	agent { 'any' }


	stages {
    		stage('Initialize')
    		{
        		def dockerHome = tool 'DOCKER_HOME'
        		def mavenHome  = tool 'M2_HOME'
        		env.PATH = "${dockerHome}:${mavenHome}/bin:${env.PATH}"
    		}
   		stage {
		    agent {
			docker 'maven:3.5-alphine'
		    }
		}
		stage ('Checkout') {
			steps {
				git 'https://github.com/tektutor/maven-hello-project.git'
			}
		}
		stage ('Build') {
			steps {
				sh 'mvn clean package'
				junit '**/target/surefire-reports/TEST-*.xml'
				archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
			}
		}
	}
}
