package com.techcasita.jersey.client;

import org.json.JSONObject;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class Client {

    private String mURL = "http://requestb.in/16b0swd1";
    private String payload = "{\"Name\":\"Wolf\"}";

    private boolean request() {
        boolean result = false;
        javax.ws.rs.client.Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(mURL);
        JSONObject jsonObject = new JSONObject(payload);

        Response response = webTarget.request(MediaType.APPLICATION_JSON).post(Entity.json(jsonObject.toString()));

        if (response.getStatus() == 200) {

            System.out.println(jsonObject.toString());
        }
        return true;
    }

    public static void main(String[] args) {
        new Client().request();
    }
}
