package com.ensam.donation.service;

import com.ensam.donation.dto.DonDto;

import java.util.List;

public interface IDonService {
    DonDto addDon(DonDto donDto);
    List<DonDto> getDons();
    DonDto getDonById(Integer id);
    DonDto updateDon(Integer id, DonDto donDto);
    void deleteDon(Integer id);
}
