def call(String project, String imageTag, String dockerHubUser){
    sh '''
      docker build {$dockerHubUser}/${JOB_NAME}
      docker image tag {$dockerHubUser}/${project} {$dockerHubUser}/${project}:${imageTag}
      docker image tag {$dockerHubUser}/${project} {$dockerHubUser}/${project}:latest
    '''
}