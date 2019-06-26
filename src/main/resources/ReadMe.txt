Author: Suresh_Gotike

This is Read me file.

urls:
http://localhost:8085/movies/getMovieDocs
http://localhost:8085/movies/getMovies
http://localhost:8085/movies/createMovieDoc



Dev Notes:
1. Hot deployment is enabled as follows.

configurations {
	dev
	runtimeClasspath {
		extendsFrom dev
	}
}


dependencies {
	dev("org.springframework.boot:spring-boot-devtools")
}


bootRun {
	// Use Spring Boot DevTool only when we run Gradle bootRun task
	classpath = sourceSets.main.runtimeClasspath + configurations.dev
}

 - open 2 terminals
   - run "./gradlew clean build -continuous" in terminal one
   - run "./gradlew bootRun" in terminal two

2. start the app in local

3. Json Database:
   The movie data is presently kept in Json file as well if you want to access the data without connecting to any database.
   file name - movieList.json
   a. access following urls to get the data from json file.
      GET : http://localhost:8081/movies/getMovies


4. Mongo DB - local DB
   a. install mongo db in local
   b. set the paths in .base_profile file present in /usr/local/userid/ folder.
      export MONGO_PATH=/usr/local/mongodb
      export PATH=$PATH:$MONGO_PATH/bin

   c. navigate to mongo home and run "mongod" command to start mongo daemon
   d. go to another terminal and run, "mongo" command to start the mongo cli
   e. run the command "use moviedb". this will create db schema.

5. run the spring boot application in local, it will create the collection with name "Movies" in database.

6. run the apis as follows.
   a. GET
      https://movieservice.cfapps.io/movies/getMovieDocs

      POST:
      http://localhost:8081/movies/createMovieDoc
      body:
        {
            "movieId": 2,
            "movieName":"Athadu",
            "movieDescription": "Mahesh Babu Movie",
            "movieImage": "image",
            "rating": 4.2
          }
       Headers:
        content-type: application/json
        accept: application/json


7. Mongo DB PCF:
   create Mongo DB service instance in PCF and bind this with the app after deployment
   a. create Mongo DB service:
       cf create-service mlab sandbox moviedb
   b. login in to PCF apps manager and bind the service with app. it will automatically connect the PCF mongo database to the app
   c. restage the app
   d. access the app urls. it will add/fetch the data from the PCF mongo db instance


8. push the app to PCF
   use corresponding manifest files created under project home directory
   a. cf push -f manifest_prod.yml


Docker:

1.  check docker version.
    docker -v
    if not installed, install the docker first

2.  create docker file
    a. file name: Dockerfile.txt

3.  create docker image:
    run this command - "docker -f Dockerfile -t movieservice-img ."

4. check if the image is created.
   "docker images"

4. run the docker image
   "docker run -it -p 8082:8081 movieservice-img"


Docker Hub:
 1. login
    "docker login"

2. tag the image
   "docker tag movieservice-img sureshgotike/movies:part1"

3. copy the image from local to docker hub
   "docker push sureshgotike/movies:part1"

4. run the docker hub tag from anywhere
   a. open terminal and login to docker hub
   b. "docker run sureshgotike/movies:part1"
       it will start the application from any terminal where you run from..


 Kubernetes:

 1. download minikube using brew command
 2. minikube start
    it will create a cluster by downloading a Virtual box from oracle and using a virtual box VM driver -- this is default driver
     you will see this message
     🏄  Done! kubectl is now configured to use "minikube"
 3. check minikube dash board in local browser.. it will show you the details about local running minikube..
     "minikube dashboard"
 4. Opening http://127.0.0.1:49669/api/v1/namespaces/kube-system/services/http:kubernetes-dashboard:/proxy/ in your default browser...

 5. check the current cluster info of the running cluster in kubernetes.
    "kubectl cluster-info"
     Kubernetes master is running at https://192.168.99.100:8443

     KubeDNS is running at https://192.168.99.100:8443/api/v1/namespaces/kube-system/services/kube-dns:dns/proxy


 6. current running nodes under this cluster
    "kubectl get nodes"

    NAME       STATUS    ROLES     AGE       VERSION
    minikube   Ready     master    20m       v1.14.3

 7. deploy the docker hub image in kubernetes
    "kubectl run movieservice --image=sureshgotike/movies:part1 --port=8080"
    deployment.apps "movieservice" created

    "kubectl get deployments"

    NAME           DESIRED   CURRENT   UP-TO-DATE   AVAILABLE   AGE
    movieservice   1         1         1            0           1m

8.  it will create a pod for us with this deployment inside the node.
    "kubectl get pods"
    NAME                           READY     STATUS             RESTARTS   AGE
    movieservice-5df46f6c6-xx745   0/1       ImagePullBackOff   0          2m

9. kubectl expose deployment/movieservice --type="NodePort" --port 8080

   service "movieservice" exposed -- this is the output

10. "kubectl describe services/movieservice"
   Name:                     movieservice
   Namespace:                default
   Labels:                   run=movieservice
   Annotations:              <none>
   Selector:                 run=movieservice
   Type:                     NodePort
   IP:                       10.107.77.202
   Port:                     <unset>  8080/TCP
   TargetPort:               8080/TCP
   NodePort:                 <unset>  31939/TCP -- take this node port
   Endpoints:
   Session Affinity:         None
   External Traffic Policy:  Cluster
   Events:                   <none>
11. now we are ready with node port of the service. use this node port number to acces this particular service inside the cluster

12. as the service cannot be accessed directly, we have to access this using the kuberentes(cluster) ip address followed by the node port number.
13. so get the ip address of the cluster(master/kubernetes)
14. "minikube ip"
     192.168.99.100
15. access the service from browser
    http://192.168.99.100:31939/movies/getMovies



