package com.brainwork.CarRentalProject.services.Impl;

import com.brainwork.CarRentalProject.entities.FinalConfirm;
import com.brainwork.CarRentalProject.exceptions.ResourceNotFoundException;
import com.brainwork.CarRentalProject.repositeries.BookingRepo;
import com.brainwork.CarRentalProject.repositeries.FinalConfirmRepo;
import com.brainwork.CarRentalProject.request.FinalConfirmResponse;
import com.brainwork.CarRentalProject.request.FinalConfirmRequest;
import com.brainwork.CarRentalProject.services.AtmService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AtmServiceImpl implements AtmService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private FinalConfirmRepo finalConfirmRepo;

    @Override
    public FinalConfirmResponse finalConfirm(FinalConfirmRequest finalConformRequest) {
        FinalConfirm finalConform=modelMapper.map(finalConformRequest,FinalConfirm.class);
        String id = UUID.randomUUID().toString();
        finalConform.setId(id);
        finalConform=this.finalConfirmRepo.save(finalConform);
        FinalConfirmResponse finalConfirmResponse=modelMapper.map(finalConform,FinalConfirmResponse.class);


        return finalConfirmResponse;
    }

    @Override
    public List<FinalConfirm> getTicketDetails(String email) {

      List<FinalConfirm>finalConfirm= finalConfirmRepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundException("email","email",email));
        List<FinalConfirm> finalConforms = finalConfirm.stream()
                .map(finalConform1 -> modelMapper.map(finalConform1, FinalConfirm.class))
                .collect(Collectors.toList());
        return finalConforms;

    }
}