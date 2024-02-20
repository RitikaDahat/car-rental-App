package com.brainwork.CarRentalProject.services.Impl;

import com.brainwork.CarRentalProject.exceptions.DriverNotFoundException;
import com.brainwork.CarRentalProject.payloads.DriverDto;
import com.brainwork.CarRentalProject.repositeries.DriverRepo;
import com.brainwork.CarRentalProject.services.DriverService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import  com.brainwork.CarRentalProject.entities.Driver;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepo driverRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DriverDto createDriver(DriverDto driverDto) {
        Driver driver = modelMapper.map(driverDto,Driver.class);
        String id= UUID.randomUUID().toString();
        driver.setId(id);
        driverRepo.save(driver);
        DriverDto driverDto1=this.modelMapper.map(driver, DriverDto.class);
        return driverDto1;
    }

    @Override
    public List<DriverDto> getAllDrivers() {
        return driverRepo.findAll().stream().map(e-> modelMapper
                .map(e, DriverDto.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteDriver(String id) {
        Driver driver = driverRepo.findById(id).orElseThrow(() -> new DriverNotFoundException(id));
        driverRepo.deleteById(id);
        return "driver removed";
    }
}
