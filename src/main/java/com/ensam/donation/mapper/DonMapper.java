package com.ensam.donation.mapper;

import com.ensam.donation.dao.entities.Don;
import com.ensam.donation.dto.DonDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DonMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Don fromDonDtoToDon(DonDto donDto) {
        return modelMapper.map(donDto, Don.class);
    }

    public DonDto fromDonToDonDto(Don don) {
        return modelMapper.map(don, DonDto.class);
    }
}
