def call(string project, string imageTag, string dockerHubUser){
    sh '''
      docker buid -t {$dockerHubUser}/${project}
      docker image tag  {$dockerHubUser}/${project} {$dockerHubUser}/${project}:${imageTag}
      docker image tag  {$dockerHubUser}/${project} {$dockerHubUser}/${project}:latest
    '''
}