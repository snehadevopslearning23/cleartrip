pipeline {
    options {
       buildDiscarder(logRotator(numToKeepStr: '5' , artifactNumToKeepStr: '5'))

    }
    agent any

    tools {
       maven  'maven_3.9.4'
    }

 stages{
    stage('Code Complilation') {
    steps {
    echo 'Code Compilation is in progress!'
    sh 'mvn clean compile'
     echo 'Code Compilation is completed successfully!'
    }
    }
  stage('Code QA execution') {
    steps {
    echo 'Junit test check is in progress!'
    sh 'mvn clean test'
     echo 'Junit test check completed successfully!'
    }
    }

      stage('Code package') {
        steps {
        echo 'creating war artifact!'
        sh 'mvn clean package'
         echo 'creating war artifact completed successfully!'
        }

        }

         stage('building docker image') {
                steps {
                echo 'start building docker image !'
                sh 'docker build -t snehadevopslearning/cleartrip .'
                echo 'creating war artifact completed successfully!'
                }

         }

              stage('image scan') {
                             steps {
                             echo 'start image scanning !'
                             sh 'java --version'
                             sh 'mvn clean package'
                             }

                          }

                             stage(' Docker push to Docker Hub') {
                                     steps {
                                        script {
                                           withCredentials([string(credentialsId: 'dockerhubCred', variable: 'dockerhubCred')]){
                                           sh 'docker login docker.io -u snehadevopslearning -p ${dockerhubCred}'
                                           echo "Push Docker Image to DockerHub : In Progress"
                                           sh 'docker push snehadevopslearning/cleartrip:latest'
                                           echo "Push Docker Image to DockerHub : In Progress"
                                           sh 'whoami'
                                           }
                                        }
                                      }
                                       }

                                         stage('Upload the docker Image to Nexus') {
                                                  steps {
                                                     script {
                                                        withCredentials([usernamePassword(credentialsId: 'nexuscred', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
                                                        sh 'docker login http://3.110.88.154:8085/repository/cleartrip/ -u admin -p ${PASSWORD}'
                                                        echo "Push Docker Image to Nexus : In Progress"
                                                        sh 'docker tag cleartrip:latest 3.110.88.154:8085/cleartrip:dev-cleartrip-v.1.${BUILD_NUMBER}'
                                                        sh 'docker push 3.110.88.154:8085/cleartrip'
                                                        echo "Push Docker Image to Nexus : Completed"
                                                        }
                                                     }
                                                   }
                                               }
        }
        }

