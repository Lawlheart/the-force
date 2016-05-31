package com.lawlietblack.theforce.client;

import com.lawlietblack.theforce.model.Device;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class DeviceClient {
    private Client client;

    public DeviceClient() {
        client = ClientBuilder.newClient();
    }

    // CREATE
    public Device create(Device device) {
        WebTarget target = client.target("http://localhost:8080/api");
        Response response = target.path("/devices").request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(device, MediaType.APPLICATION_JSON));
        if(response.getStatus() != 200) throw new RuntimeException(response.getStatus() + ": Internal Server Error");

        return response.readEntity(Device.class);
    }

    // READ
    public Device get(String id) {
        WebTarget target = client.target("http://localhost:8080/api/");
        Response response = target.path("devices/" + id).request().get(Response.class);
        if(response.getStatus() != 200) throw new RuntimeException(response.getStatus() + ": Server Error");

        return response.readEntity(Device.class);
    }

    public List<Device> get() {
        WebTarget target = client.target("http://localhost:8080/api/");
        List<Device> response = target.path("devices/").request().get(new GenericType<List<Device>>() {});
        return response;
    }

    // UPDATE
    public Device update(Device device) {
        WebTarget target = client.target("http://localhost:8080/api");
        Response response = target.path("/devices/" + device.getId()).request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(device, MediaType.APPLICATION_JSON));
        System.out.println(response);
        if(response.getStatus() != 200) throw new RuntimeException(response.getStatus() + ": Internal Server Error");

        return response.readEntity(Device.class);
    }

    public void delete(int id) {
        WebTarget target = client.target("http://localhost:8080/api");
        Response response = target.path("/devices/" + id).request(MediaType.APPLICATION_JSON).delete();
        System.out.println(response);
        if(response.getStatus() != 200) throw new RuntimeException(response.getStatus() + ": Internal Server Error");
    }
}
