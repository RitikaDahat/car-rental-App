package com.brainwork.CarRentalProject.services;

import com.brainwork.CarRentalProject.entities.User;
import com.brainwork.CarRentalProject.payloads.UserDto;

public interface UserService {
    UserDto registerNewUser(UserDto userDto);
    UserDto authenticateUser(String email, String password);

    String editUser(UserDto userDto, String userId);
    String deleteUser(String userId);
}
