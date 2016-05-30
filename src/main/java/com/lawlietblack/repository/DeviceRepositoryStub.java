package com.lawlietblack.repository;

import com.lawlietblack.model.Device;

import java.util.Arrays;
import java.util.List;

public class DeviceRepositoryStub implements DeviceRepository {
    private List<Device> ALL_DEVICES = Arrays.asList(
            new Device(1, "Ceiling Fan", "fan", "Living Room", "off"),
            new Device(2, "Heater", "climate", "Living Room", "off"),
            new Device(3, "Main AC", "climate", "Bedroom", "off"),
            new Device(4, "Mini AC", "climate", "Living Room", "68"),
            new Device(5, "Bedroom Light", "light", "Bedroom", "off"),
            new Device(6, "Front Door", "lock", "Living Room", "locked")
    );



    @Override
    public List<Device> findAllDevices() {
        return ALL_DEVICES;
    }

    @Override
    public Device findDeviceById(Integer id) {
        for(Device device : ALL_DEVICES) {
            if(device.getId() == id) {
                return device;
            }
        }
        return null;
    }
}
