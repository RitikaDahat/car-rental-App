package com.brainwork.CarRentalProject.services.Impl;

import com.brainwork.CarRentalProject.entities.User;
import com.brainwork.CarRentalProject.exceptions.ResourceNotFoundException;
import com.brainwork.CarRentalProject.exceptions.UserNotFoundException;
import com.brainwork.CarRentalProject.payloads.UserDto;
import com.brainwork.CarRentalProject.repositeries.UserRepo;
import com.brainwork.CarRentalProject.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerNewUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User saveUser = userRepo.save(user);
        return this.modelMapper.map(saveUser,UserDto.class);
    }
    @Override
    public UserDto authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("email", "email", email));

        // Assuming user.getEmail() returns the email stored in the database
        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
            return modelMapper.map(user, UserDto.class);
        } else {
            throw new RuntimeException("Invalid email or password");
        }
    }

    @Override
    public String editUser(UserDto userDto, String userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        user.setDob(userDto.getDob());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        if(userRepo.save(user)!=null) return "Changes saved successfully";
        return "User not updated, please try again";
    }

    @Override
    public String deleteUser(String userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        userRepo.delete(user);
        return "User deleted successfully";
    }
}
