package com.brainwork.CarRentalProject.controllers;

import com.brainwork.CarRentalProject.entities.Driver;
import com.brainwork.CarRentalProject.payloads.DriverDto;
import com.brainwork.CarRentalProject.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/drivers")
@CrossOrigin
public class DriverController {

    @Autowired
    private DriverService driverService;


    @PostMapping("/create")
    public ResponseEntity<DriverDto> createDriver(@RequestBody DriverDto driverDto){
        DriverDto driverDto1 = driverService.createDriver(driverDto);
        return new ResponseEntity<>(driverDto1, HttpStatus.CREATED);
    }
    @GetMapping("/AllDrivers")
    public ResponseEntity<List<DriverDto>> getAllDrivers(){
       List<DriverDto> driver = driverService.getAllDrivers();
        return new ResponseEntity<>(driver,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDriver(@PathVariable("id") String id){
       String driver = driverService.deleteDriver(id);
       return new ResponseEntity<>(driver,HttpStatus.OK);
    }
}
