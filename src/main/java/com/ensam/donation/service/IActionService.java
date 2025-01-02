package com.ensam.donation.service;

import com.ensam.donation.dto.ActionDto;
import com.ensam.donation.dto.DonDto;

import java.util.List;

public interface IActionService {
    ActionDto addAction(ActionDto actionDto);
    List<ActionDto> getActions();
    ActionDto getActionById(Integer id);
    List<DonDto> getDonsOfActionById(Integer actionId);
}
