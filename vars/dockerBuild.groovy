def call(String project, String ImageTag, String DockerHubUser){
    sh """
      docker image build -t ${DockerHubUser}/${project} . 
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:${ImageTag}
      docker image tag ${hubUser}/${project} ${hubUser}/${project}:latest
     """
}