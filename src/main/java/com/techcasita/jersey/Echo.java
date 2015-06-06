package com.techcasita.jersey;

import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("echo")
public class Echo {

    @GET
    @Produces("text/plain")
    public String echo(@QueryParam("m") final String message) {
        Logger.getLogger(getClass()).info("Request received with m=" + message);
        return "echo: " + message;
    }
}
