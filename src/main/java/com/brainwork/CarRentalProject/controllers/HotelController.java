package com.brainwork.CarRentalProject.controllers;

import com.brainwork.CarRentalProject.payloads.HotelDto;
import com.brainwork.CarRentalProject.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotels")
@CrossOrigin
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @PostMapping("/create")
    public ResponseEntity<HotelDto> createHotel(@RequestBody HotelDto hotelDto){
        HotelDto hotelDto1=hotelService.createHotel(hotelDto);
        return new ResponseEntity<>(hotelDto1, HttpStatus.CREATED);
    }
    @GetMapping("/AllHotels")
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        List<HotelDto> hotelDtos = hotelService.getAllHotels();
        return new ResponseEntity<>(hotelDtos,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHotel(@PathVariable("id") String id){
        String hotel = hotelService.deleteHotel(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
}
