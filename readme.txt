While I'm sharing this project here on github, I really did this for myself and always it as a starting point for Java-based Web applications. It's a very simple and straight forward implementation of Jersey 2.0 with only the absolutely necessary libraries included. 

See for yourself. Check it out, build and delpoy the war file into your favorite container ...

Compiles / Build / Packaging using gradle, like so:
./gradle build
./gradlew war

The war file is compiled to: build/libs/JerseyTemplate-1.0.war

Deployed into a local Tomcat instance and then send an HTTP GET request like so:
http://localhost:8080/rest/echo?m=hello
