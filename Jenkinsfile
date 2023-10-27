@Library('my-shared-library') _
pipeline {
    agent any
    
    tools {
        maven 'maven'
    }
    
    stages {
        
        stage('git checkout') {
                
            steps {
                gitCheckout(
                    branch: "main",
                    url: "https://github.com/ali-as64/jenkins-shared-lib.git"
                    )
            }
        }
        stage("Build Application"){
            steps {
                sh "mvn install"
            }

        }
        stage('Unit Test maven') {
            
            steps {
               script{
                 mavenTest()
                }
            }
        }
        
        stage('Integration test maven') {
            
            steps {
                script{
                    mavenIntegrationTest()
                }
            }
        }
        
        stage('static code analysis') {
            
            steps {
                script{
                    staticCodeAnlysis()
                }
            }
        }
        
    }
}