1) Compiles / Build / Packaging using gradle.
./gradle build
./gradlew war

The war file is compiled to: build/libs/jersey.war

Deployed into a local Tomcat instance
Indexpage:
http://localhost:8080

requests go like this:
http://localhost:8080/rest/echo?m=hello

Swagger Json:
http://localhost:8080/rest/api-docs

Fancy doc:
http://localhost:8080/api/
http://localhost:8080/api/#!/echo/post