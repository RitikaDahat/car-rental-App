package com.brainwork.CarRentalProject.controllers;

import com.brainwork.CarRentalProject.request.BookingRequest;
import com.brainwork.CarRentalProject.request.BookingResponse;
import com.brainwork.CarRentalProject.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/mybooking")
@CrossOrigin
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book-now")
    public ResponseEntity<BookingResponse> bookCar(@RequestBody BookingRequest bookingRequest){
        BookingResponse bookedCar = bookingService.bookCar(bookingRequest);
        return new ResponseEntity<>(bookedCar, HttpStatus.OK);
    }

    }

