package com.brainwork.CarRentalProject.services;

import com.brainwork.CarRentalProject.payloads.HotelDto;
import com.brainwork.CarRentalProject.repositeries.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HotelService {
    HotelDto createHotel(HotelDto hotelDto);

    List<HotelDto> getAllHotels();

    String deleteHotel(String id);
}
