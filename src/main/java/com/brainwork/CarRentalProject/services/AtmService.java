package com.brainwork.CarRentalProject.services;

import com.brainwork.CarRentalProject.entities.FinalConfirm;
import com.brainwork.CarRentalProject.request.FinalConfirmResponse;
import com.brainwork.CarRentalProject.request.FinalConfirmRequest;

import java.util.List;

public interface AtmService {
    FinalConfirmResponse finalConfirm(FinalConfirmRequest finalConfirmRequest);

    //FinalConfirmResponse finalConform(FinalConfirmRequest finalConformRequest);

    public List<FinalConfirm> getTicketDetails(String email);
}
