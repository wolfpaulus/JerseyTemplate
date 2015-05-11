1) Compiles / Build / Packaging using gradle.
./gradle build
./gradlew war

The war file is compiled to: build/libs/JerseyTemplate-1.0.war

Deployed into a local Tomcat instance, requests go like so:
http://localhost:8080/rest/echo?m=hello
