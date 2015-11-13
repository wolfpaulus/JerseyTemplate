package com.techcasita.jersey;

import com.google.gson.Gson;
import com.techcasita.jersey.model.Person;
import com.techcasita.jersey.model.Persons;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("echo")
@Api(value = "/echo", description = "Echo QueryParam")

public class Echo {

    @GET
    @Consumes(MediaType.WILDCARD)
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(
            value = "Echos an input parameter ",
            notes = "nothing special to be noted here",
            response = String.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Text successfully echo-ed"),
            @ApiResponse(code = 400, message = "error during echo")
    })
    public String echo(@QueryParam("m") final String message) {
        Logger.getLogger(getClass()).info("Request received with m=" + message);
        return "echo: " + message;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(
            value = "Turns the provided string into a Person array.",
            notes = "Using the gson marshalling",
            response = Response.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Person array instantiated "),
            @ApiResponse(code = 400, message = "error during json processing")
    })
    public Response post(
            @ApiParam(value = "Json to be converted into Person[] try something like: [{\"name\":\"Wolf\",\"email\":\"wolf@wolfpaulus.com\"}]")
            final String jsonString ) {
        final Gson gson = new Gson();
        final Person[] result = gson.fromJson(jsonString, Person[].class);
        return Response.ok("Number of Person object instantiated: " +  result.length).build();
    }
}
