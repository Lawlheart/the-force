package com.lawlietblack.theforce.service;

import com.lawlietblack.theforce.model.Device;
import com.lawlietblack.theforce.repository.DeviceRepository;
import com.lawlietblack.theforce.repository.DeviceRepositoryImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.util.List;

@Path("devices")
public class DeviceService {
    private DeviceRepository deviceRepository = new DeviceRepositoryImpl();

    // CREATE
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Device createDevice(Device device){
        deviceRepository.create(device);
        return device;
    }

    // READ
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Device> getAllDevicesXml() {
        return deviceRepository.findAllDevices();
    }


    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getDeviceById(@PathParam("id") Integer id) {
        if(id == null) return Response.status(Status.BAD_REQUEST).build();
        Device device = deviceRepository.findDeviceById(id);
        if(device == null) return Response.status(Status.NOT_FOUND).build();
        return Response.ok().entity(device).build();
    }

    // UPDATE
    @PUT
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDevice(Device device) {
        device = deviceRepository.update(device);
        return Response.ok().entity(device).build();
    }

    // DELETE
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteDevice(@PathParam("id") Integer id) {
        deviceRepository.delete(id);
        return Response.ok().build();
    }
}
