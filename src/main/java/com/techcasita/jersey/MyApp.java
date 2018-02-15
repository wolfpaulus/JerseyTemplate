package com.techcasita.jersey;

import io.swagger.jaxrs.config.BeanConfig;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-Jersey-2.X-Project-Setup-1.5#using-the-application-class
@ApplicationPath("service")
public class MyApp extends Application {
    public MyApp() {
        final BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("@VERSION@");
        beanConfig.setBasePath("/jersey/service");
        beanConfig.setResourcePackage("com.techcasita.jersey");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();
        resources.add(Echo.class);
        resources.add(MultiPartFeature.class);
        //...
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}