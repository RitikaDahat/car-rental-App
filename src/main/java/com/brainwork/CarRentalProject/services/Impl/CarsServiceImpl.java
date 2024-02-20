package com.brainwork.CarRentalProject.services.Impl;

import com.brainwork.CarRentalProject.entities.Cars;
import com.brainwork.CarRentalProject.exceptions.CarNotFoundException;
import com.brainwork.CarRentalProject.payloads.CarsDto;
import com.brainwork.CarRentalProject.payloads.UserDto;
import com.brainwork.CarRentalProject.repositeries.CarsRepo;
import com.brainwork.CarRentalProject.services.CarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@Service
public class CarsServiceImpl implements CarsService {

    @Autowired
    private CarsRepo carsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CarsDto saveCar(CarsDto carsDto) {
        Cars cars = this.modelMapper.map(carsDto, Cars.class);
        String id= UUID.randomUUID().toString();
        cars.setId(id);
        Cars saveCars = carsRepo.save(cars);
        return this.modelMapper.map(saveCars, CarsDto.class);
    }

    @Override
    public List<CarsDto> getAllCars() {
        return carsRepo.findAll().stream()
                .map(e -> modelMapper.map(e, CarsDto.class)).collect(Collectors.toList());
    }

    @Override
    public CarsDto getCarById(String id) {
        Optional<Cars> optionalCar = carsRepo.findById(id);
        if (optionalCar.isPresent()) {
            Cars car = optionalCar.get();
            return modelMapper.map(car, CarsDto.class);
        } else {
            return null;
        }
    }

    @Override
    public String deleteById(String id) {
        Cars cars = carsRepo.findById(id).orElseThrow(() -> new CarNotFoundException(id));
        carsRepo.deleteById(id);
        return "Car Deleted";
    }
}

