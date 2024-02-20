package com.brainwork.CarRentalProject.services.Impl;

import com.brainwork.CarRentalProject.entities.Hotel;
import com.brainwork.CarRentalProject.exceptions.DriverNotFoundException;
import com.brainwork.CarRentalProject.exceptions.ResourceNotFoundException;
import com.brainwork.CarRentalProject.payloads.HotelDto;
import com.brainwork.CarRentalProject.repositeries.HotelRepo;
import com.brainwork.CarRentalProject.services.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel hotel=this.modelMapper.map(hotelDto,Hotel.class);
        String id= UUID.randomUUID().toString();
        hotel.setId(id);
        Hotel savehotel = hotelRepo.save(hotel);
        return this.modelMapper.map(savehotel,HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {
       return hotelRepo.findAll().stream()
               .map(e->modelMapper.map(e,HotelDto.class)).collect(Collectors.toList());
    }

    @Override
    public String deleteHotel(String id) {
        Hotel hotel=hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        hotelRepo.deleteById(id);
        return "hotel removed";
    }
    }

