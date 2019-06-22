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


2.
