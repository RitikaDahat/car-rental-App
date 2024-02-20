package com.brainwork.CarRentalProject.services;

import com.brainwork.CarRentalProject.payloads.CarsDto;
import com.brainwork.CarRentalProject.payloads.UserDto;

import java.util.List;

public interface CarsService {
    CarsDto saveCar(CarsDto carsDto);

    List<CarsDto> getAllCars();

    CarsDto getCarById(String id);

    String deleteById(String id);
}
