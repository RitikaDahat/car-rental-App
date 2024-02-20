package com.brainwork.CarRentalProject.exceptions;

import com.brainwork.CarRentalProject.entities.Booking;

public class BookingNotFoundException extends RuntimeException{
    public BookingNotFoundException(String id){
        super("No such car found with id: "+id);
    }
}
