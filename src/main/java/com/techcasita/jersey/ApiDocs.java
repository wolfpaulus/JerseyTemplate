package com.techcasita.jersey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Path("/api-docs")
@Api(value = "/api-docs", description = "Swagger Api Documentation")
public class ApiDocs {
    private static final Logger Log = Logger.getLogger(ApiDocs.class);

    @GET
    @Produces("application/json;charset=UTF-8")
    @ApiOperation(
            value = "Returns Swagger Api Documentation json ",
            notes = "aka, the yaml file",
            response = Response.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "doc successfully created"),
            @ApiResponse(code = 400, message = "error")
    })
    public void get(@Context HttpServletRequest request,
                    @Context HttpServletResponse response) throws Exception {
        Log.info("ApiDocs Request received");
        request.getRequestDispatcher("swagger.json").forward(request, response);
    }

}
