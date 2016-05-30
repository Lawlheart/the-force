package com.lawlietblack.service;

import com.lawlietblack.model.Device;
import com.lawlietblack.repository.DeviceRepository;
import com.lawlietblack.repository.DeviceRepositoryStub;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("devices")
public class DeviceService {
    private DeviceRepository deviceRepository = new DeviceRepositoryStub();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Device> getAllDevicesXml() {
        return deviceRepository.findAllDevices();
    }


    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Device getDeviceById(@PathParam("id") Integer id) {
        return deviceRepository.findDeviceById(id);
    }

}
