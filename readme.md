## Compile / Build / Packaging using gradle  
`./gradle build`  
`./gradlew war`

The war file is compiled to build/libs/jersey.war

## Deploying 
Deploy the war by copying it into a web container such as [Tomcat](http://tomcat.apache.org)  
`cp build/libs/jersey.war $TOMCAT_HOME/webapps/`   
`$TOMCAT_HOME/bin/startup.sh`

## Usage 
When deployed into a local Tomcat instance, the index page is  
http://localhost:8080

An example:  
http://localhost:8080/jersey/service/echo?m=Hello
## Documentation 
Swagger Json:  
http://localhost:8080/jersey/api-docs

Since there isn't a web.xml file, look for the context name inside the MyApp.java class.
The name of the webapp is declared in the build.grade file 
E.g. Once the jersey.war get deployed onto a app server, you'd access like this:  


* http://localhost:8080/jersey/
* http://localhost:8080/jersey/service/echo?m=hello  
* http://localhost:8080/jersey/api-docs/  




