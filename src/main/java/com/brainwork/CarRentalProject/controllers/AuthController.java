package com.brainwork.CarRentalProject.controllers;
import com.brainwork.CarRentalProject.exceptions.ApiException;
import com.brainwork.CarRentalProject.request.JwtAuthRequest;
import com.brainwork.CarRentalProject.request.JwtAuthResponse;
import com.brainwork.CarRentalProject.repositeries.UserRepo;
import com.brainwork.CarRentalProject.security.JwtUtil;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.brainwork.CarRentalProject.entities.User;
import com.brainwork.CarRentalProject.payloads.UserDto;
import com.brainwork.CarRentalProject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto){
    UserDto userDto1 = userService.registerNewUser(userDto);

    return new ResponseEntity<UserDto>(userDto1, HttpStatus.CREATED);

    }

@PostMapping("/login")
public ResponseEntity<Map<String,Object>> createAuthenticationToken(@Valid @RequestBody JwtAuthRequest authenticationRequest) throws Exception {

    User user = new User();

    try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );
        user = userRepo.findByEmail(authenticationRequest.getEmail())
                .orElseThrow(()->new ApiException("Incorrect username or password"));
    }
    catch (BadCredentialsException e) {
        throw new ApiException("Incorrect username or password");
    }


    UserDetails userDetails = userDetailsService
            .loadUserByUsername(authenticationRequest.getEmail());

    String jwt = jwtUtil.generateToken(userDetails);

    JwtAuthResponse response = new JwtAuthResponse();
    response.setAuth(jwt);
    response.setUser(modelMapper.map(user, UserDto.class));

    Map<String,Object> map= new HashMap<>();
    map.put("user",user);
    map.put("token",jwt);

    return ResponseEntity.ok(map);
}
}


