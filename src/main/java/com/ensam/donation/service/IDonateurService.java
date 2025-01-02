package com.ensam.donation.service;

import com.ensam.donation.dto.DonateurDto;

import java.util.List;

public interface IDonateurService {
    DonateurDto addDonateur(DonateurDto donateurDto);
    List<DonateurDto> getDonateurs();
    DonateurDto getDonateurById(Integer id);
    DonateurDto updateDonateur(Integer id, DonateurDto donateurDto);
    void deleteDonateur(Integer id);
}
