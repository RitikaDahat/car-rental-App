package com.brainwork.CarRentalProject.repositeries;

import com.brainwork.CarRentalProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
//    User findByEmail(String email, String password);
}
