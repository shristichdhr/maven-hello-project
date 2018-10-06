pipeline {
	agent { docker 'maven' }

    	stage('Initialize')
    	{
        	def dockerHome = tool 'MyDocker'
        	def mavenHome  = tool 'MyMaven'
        	env.PATH = "${dockerHome}/bin:${mavenHome}/bin:${env.PATH}"
    	}

	stages {
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
