package com.techcasita.jersey.remote;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/")
public interface IPixy {
    @POST
    @Path("/talk")
    @Produces("text/xml")
    String talk(@FormParam("bot") String bot,
                @FormParam("input") String input,
                @FormParam("session") String session);
}
