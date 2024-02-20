package com.brainwork.CarRentalProject.controllers;

import com.brainwork.CarRentalProject.entities.Cars;
import com.brainwork.CarRentalProject.payloads.CarsDto;
import com.brainwork.CarRentalProject.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/car")
@CrossOrigin
public class CarController {
    @Autowired
    private CarsService carsService;

    @PostMapping("/add")
    public ResponseEntity<CarsDto> saveCars(@RequestBody CarsDto carsDto){
        CarsDto carsDto1=carsService.saveCar(carsDto);
        return new ResponseEntity<>(carsDto1, HttpStatus.OK);
    }

    @GetMapping("/AllCars")
    public ResponseEntity<List<CarsDto>> getAllCars() {
        List<CarsDto> cars = carsService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public CarsDto getCarById(@PathVariable String id) {
        return carsService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable String id){
        String carsDto =this.carsService.deleteById(id);
        return new ResponseEntity<>(carsDto,HttpStatus.OK);

    }
}
