package com.lawlietblack.theforce.client;

import com.lawlietblack.theforce.model.Device;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DeviceClientTest {

    // CREATE
    @Test
    public void testCreate() {
        DeviceClient client = new DeviceClient();

        Device device = new Device();
        device.setName("Garage Door");
        device.setType("door");
        device.setRoom("garage");
        device.setStatus("closed");

        device = client.create(device);

        assertNotNull(device);
        //assertNotNull(device.getId());
    }

    // READ
    @Test
    public void testGet() throws Exception {
        DeviceClient client = new DeviceClient();
        Device device = client.get("1");

        System.out.println(device);

        assertNotNull(device);
    }

    @Test
    public void testGetList() throws Exception {
        DeviceClient client = new DeviceClient();
        List<Device> devices = client.get();

        assertNotNull(devices);
    }

    @Test(expected = RuntimeException.class)
    public void testGetWithBadRequest() {
        DeviceClient client = new DeviceClient();
        client.get("");
    }

    // UPDATE
    @Test
    public void testPut() {
        DeviceClient client = new DeviceClient();

        Device device = new Device();
        device.setId(77);
        device.setName("Garage Door");
        device.setType("door");
        device.setRoom("garage");
        device.setStatus("closed");

        device = client.update(device);

        assertNotNull(device);
    }

    // DELETE
    @Test
    public void testDelete() {
        DeviceClient client = new DeviceClient();
        client.delete(2);
    }
}