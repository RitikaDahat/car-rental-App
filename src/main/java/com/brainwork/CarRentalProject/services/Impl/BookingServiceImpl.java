package com.brainwork.CarRentalProject.services.Impl;

import com.brainwork.CarRentalProject.entities.Booking;
import com.brainwork.CarRentalProject.entities.Cars;
import com.brainwork.CarRentalProject.entities.FinalConfirm;
import com.brainwork.CarRentalProject.exceptions.CarNotFoundException;
import com.brainwork.CarRentalProject.repositeries.BookingRepo;
import com.brainwork.CarRentalProject.repositeries.CarsRepo;
import com.brainwork.CarRentalProject.repositeries.FinalConfirmRepo;
import com.brainwork.CarRentalProject.request.BookingRequest;
import com.brainwork.CarRentalProject.request.BookingResponse;
import com.brainwork.CarRentalProject.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

        @Autowired
        private BookingRepo bookingRepo;

        @Autowired
        private CarsRepo carsRepo;

        @Autowired
        private ModelMapper modelMapper;

        @Autowired
        private FinalConfirmRepo finalConfirmRepo;

        @Override
        public BookingResponse bookCar(BookingRequest bookingRequest) {
                Cars cars = this.carsRepo.findById(bookingRequest.getCarId()).orElseThrow(() -> new CarNotFoundException(bookingRequest.getCarId()));
                Booking booking = modelMapper.map(bookingRequest, Booking.class);

                BookingResponse bookingResponse = new BookingResponse();

                booking.setBookingId(UUID.randomUUID().toString());
                booking.setDays(bookingRequest.getDays());
                booking.setMembers(bookingRequest.getMembers());
                booking.setNumBags(bookingRequest.getNumBags());
                booking.setPassangerCapacity(booking.getPassangerCapacity());
                booking.setPickUpDate(bookingRequest.getPickUpDate());
                booking.setPickUpTime(bookingRequest.getPickUpTime());
                booking.setDropDate(bookingRequest.getDropDate());

                booking.setTotalPrice(cars.getCharge() * bookingRequest.getDays());
                booking.setCars(cars);
                Booking savedBooking = bookingRepo.save(booking);
                BeanUtils.copyProperties(savedBooking, bookingResponse);
                BeanUtils.copyProperties(cars, bookingResponse);


                return bookingResponse;
        }


}