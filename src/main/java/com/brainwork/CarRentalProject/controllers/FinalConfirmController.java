package com.brainwork.CarRentalProject.controllers;

import com.brainwork.CarRentalProject.entities.FinalConfirm;
import com.brainwork.CarRentalProject.request.FinalConfirmResponse;
import com.brainwork.CarRentalProject.request.FinalConfirmRequest;
import com.brainwork.CarRentalProject.services.AtmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class FinalConfirmController {
    @Autowired
    private AtmService atmService;

    @PostMapping("/finalConfirm")
    public ResponseEntity<FinalConfirmResponse> finalConfirm(@RequestBody FinalConfirmRequest finalConfirmRequest) {
        FinalConfirmResponse bookingResponse = atmService.finalConfirm(finalConfirmRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingResponse);
    }

    @GetMapping("/ticketDetails/{email}")
    public ResponseEntity<List<FinalConfirm>> getTicketDetails(@PathVariable String email) {
        List<FinalConfirm> finalConfirm = atmService.getTicketDetails(email);
        return new ResponseEntity<>(finalConfirm, HttpStatus.FOUND);

    }
}
