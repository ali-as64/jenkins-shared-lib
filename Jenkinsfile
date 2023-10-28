@Library('my-shared-library') _
pipeline {
    agent any
    
    parameters{

        choice(name: 'action', choices: 'create\ndelete', description: 'Choose create/Destroy')
        string(name: 'ImageName', description: "name of the docker build", defaultValue: 'javapp')
        string(name: 'imageTag', description: "tag of the docker build", defaultValue: 'v1')
        string(name: 'dockerHubUser', description: "name of the Application", defaultValue: 'alias64')
    }

    tools {
        maven 'maven'
    }
    
    stages {
        
        stage('git checkout') {
                when { expression {  params.action == 'create' } }
            steps {
                gitCheckout(
                    branch: "main",
                    url: "https://github.com/ali-as64/jenkins-shared-lib.git"
                    )
            }
        }
        stage("Build Application"){
                when { expression {  params.action == 'create' } }
            steps {
                sh "mvn install"
            }

        }
        stage('Unit Test maven') {
                when { expression {  params.action == 'create' } }
            steps {
               script{
                 mavenTest()
                }
            }
        }
        
        stage('Integration test maven') {
                when { expression {  params.action == 'create' } }
            steps {
                script{
                    mavenIntegrationTest()
                }
            }
        }
        
        stage('static code analysis with sonarqube') {
                when { expression {  params.action == 'create' } }
            steps {
                script{
                    def SQcredentialsId = 'sonarqube-token2'
                    staticCodeAnlysis(SQcredentialsId)
                }
            }
        }
        stage('quality gate analysis check with sonarqube') {
                when { expression {  params.action == 'create' } }
            steps {
                script{
                    def SQcredentialsId = 'sonarqube-token2'
                    qualityGateStatus(SQcredentialsId)
                }
            }
        }
        stage('maven build: maven') {
                when { expression {  params.action == 'create' } }
            steps {
                script{
                    mavenBuild()
                }
            }
        }stage('docker build: docker') {
                when { expression {  params.action == 'create' } }
            steps {
                script{
                    dockerBuild(params.ImageName, params.imageTag, params.dockerHubUser)
                }
            }
        }

    }
}