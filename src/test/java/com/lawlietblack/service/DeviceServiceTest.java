package com.lawlietblack.service;

import com.lawlietblack.repository.DeviceRepository;
import com.lawlietblack.repository.DeviceRepositoryStub;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;

import static org.junit.Assert.assertEquals;

// Not sure if this configuration is correct
public class DeviceServiceTest extends JerseyTest {
    private DeviceRepository deviceRepository = new DeviceRepositoryStub();

    @Override
    protected Application configure() {
        return new ResourceConfig(DeviceService.class);
    }

    @Test
    public void test() {
        final String response = target("devices").request().get(String.class);
        assertEquals(deviceRepository.findAllDevices().toString(), response);
    }
}
