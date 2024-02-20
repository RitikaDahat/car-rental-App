package com.brainwork.CarRentalProject.repositeries;

import com.brainwork.CarRentalProject.entities.FinalConfirm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FinalConfirmRepo extends JpaRepository<FinalConfirm,String> {
   Optional<List<FinalConfirm>> findByEmail(String email);
}

