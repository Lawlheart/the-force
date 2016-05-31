package com.lawlietblack.theforce.repository;

import com.lawlietblack.theforce.model.Device;

import java.util.List;

public interface DeviceRepository {
    List<Device> findAllDevices();
    Device findDeviceById(Integer id);

    Device create(Device device);

    Device update(Device device);

    void delete(Integer id);
}
