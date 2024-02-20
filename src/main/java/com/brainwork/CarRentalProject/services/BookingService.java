package com.brainwork.CarRentalProject.services;

import com.brainwork.CarRentalProject.entities.FinalConfirm;
import com.brainwork.CarRentalProject.request.BookingRequest;
import com.brainwork.CarRentalProject.request.BookingResponse;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    BookingResponse bookCar(BookingRequest bookingRequest);

}
