pipeline {
	agent { 'any' }


	stages {
    		stage('Initialize')
    		{
        		def dockerHome = tool 'DOCKER_HOME'
        		def mavenHome  = tool 'M2_HOME'
        		env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
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
