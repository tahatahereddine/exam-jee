package com.ensam.donation.mapper;

import com.ensam.donation.dao.entities.Donateur;
import com.ensam.donation.dto.DonateurDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DonateurMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Donateur fromDonateurDtoToDonateur(DonateurDto donateurDto) {
        return modelMapper.map(donateurDto, Donateur.class);
    }

    public DonateurDto fromDonateurToDonateurDto(Donateur donateur) {
        return modelMapper.map(donateur, DonateurDto.class);
    }
}
