Author: Suresh_Gotike

This is Read me file.



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
   b. set the paths in .base_profile file present in /usr/local/userid/ folder. export MONGO_HOME=path of mongodb where it got installed
      export PATH = $PATH:/$MONGO_HOME/bin
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




