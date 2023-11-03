def call(String project, String ImageTag, String DockerHubUser){
    sh """
      docker image build -t ${DockerHubUser}/${project} . 
      docker image tag ${DockerHubUser}/${project} ${DockerHubUser}/${project}:${ImageTag}
      docker image tag ${DockerHubUser}/${project} ${DockerHubUser}/${project}:latest
     """
}