package com.brainwork.CarRentalProject.repositeries;

import com.brainwork.CarRentalProject.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsRepo extends JpaRepository<Cars,String> {

}
