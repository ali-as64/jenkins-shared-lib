def call(string projrct, string imageTag, string dockerHubUser){
    sh '''
      docker buid -t {$dockerHubUser}/${projrct}
      docker image tag  {$dockerHubUser}/${projrct} {$dockerHubUser}/${projrct}:${imageTag}
      docker image tag  {$dockerHubUser}/${projrct} {$dockerHubUser}/${projrct}:latest
      '''

}