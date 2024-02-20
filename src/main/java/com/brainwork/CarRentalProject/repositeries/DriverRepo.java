package com.brainwork.CarRentalProject.repositeries;

import com.brainwork.CarRentalProject.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepo extends JpaRepository<Driver,String> {
}
