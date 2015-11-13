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

There are still two places where a URL has to be hardcoded, to make it all work.
Like you can see, currently it all defaults to run as the root context.
Once you deploy the war however ... things change.
E.g. Once the jersey.war get deployed onto a app server, you'd access like this:

http://my.server.com:8080/jersey/index.html
http://my.server.com:8080/jersey/rest/echo?m=hello
http://my.server.com:8080/jersey/api/

For swagger still to work, edit the src/main/webapp/web.xml
In the servlet declaration for the JerseyJaxrsConfig edit the URL
    <servlet>
        <servlet-name>JerseyJaxrsConfig</servlet-name>
        <servlet-class>io.swagger.jersey.config.JerseyJaxrsConfig</servlet-class>
        <init-param>
            <param-name>api.version</param-name>
            <param-value>1.0</param-value>
        </init-param>
        <init-param>
            <param-name>swagger.api.basepath</param-name>
            <param-value>http://localhost:8080/rest</param-value>
        </init-param>
        <load-on-startup>2</load-on-startup>
    </servlet>

Like so: http://localhost:8080/jersey/rest

And in the src/main/webapp/api/index.html
Again, update the URL close to the top of the file:
<script type="text/javascript">
    $(function () {
      var url = window.location.search.match(/url=([^&]+)/);
      if (url && url.length > 1) {
        url = decodeURIComponent(url[1]);
      } else {
        url = "/rest/swagger.yaml";
      }

Like so: /jersey/rest/swagger.yaml



