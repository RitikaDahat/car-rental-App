package com.brainwork.CarRentalProject.request;

import com.brainwork.CarRentalProject.payloads.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthResponse {
    private UserDto user;
    private String auth;
}
