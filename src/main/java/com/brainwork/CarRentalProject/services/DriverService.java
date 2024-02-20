package com.brainwork.CarRentalProject.services;

import com.brainwork.CarRentalProject.payloads.DriverDto;

import java.util.List;

public interface DriverService {
     DriverDto createDriver(DriverDto driverDto);

     List<DriverDto> getAllDrivers();

    String deleteDriver(String id);
}
