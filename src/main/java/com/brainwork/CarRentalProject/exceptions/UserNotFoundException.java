package com.brainwork.CarRentalProject.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException (String id){
        super("No such user found with id: "+id);
    }
}

