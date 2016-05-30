package com.lawlietblack.repository;

import com.lawlietblack.model.Device;

import java.util.List;

public interface DeviceRepository {
    List<Device> findAllDevices();
    Device findDeviceById(Integer id);
}
