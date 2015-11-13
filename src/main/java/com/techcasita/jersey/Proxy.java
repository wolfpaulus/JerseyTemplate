package com.techcasita.jersey;

import com.techcasita.jersey.remote.IPixy;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.MediaType;


@Path("proxy")
public class Proxy {
    private final IPixy p;

    public Proxy() {
        final Configuration configuration = new ResourceConfig();
        final Client client = ClientBuilder.newClient(configuration);
        final WebTarget webTarget = client.target("http://192.168.200.16:8000/cora/aiml");
        p =  WebResourceFactory.newResource(IPixy.class, webTarget);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public String talk(@FormParam("bot") String bot,
                       @FormParam("input") String input,
                       @FormParam("session") String session) {
        String s =  p.talk(bot,input,session);
        return s;
    }
}
