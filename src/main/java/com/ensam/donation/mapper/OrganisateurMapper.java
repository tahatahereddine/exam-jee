package com.ensam.donation.mapper;

import com.ensam.donation.dao.entities.Organisateur;
import com.ensam.donation.dto.OrganisateurDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrganisateurMapper {
    ModelMapper modelMapper = new ModelMapper();

    public Organisateur fromOrganisateurDtoToOrganisateur(OrganisateurDto organisateurDto) {
        return modelMapper.map(organisateurDto, Organisateur.class);
    }

    public OrganisateurDto fromOrganisateurToOrganisateurDto(Organisateur organisateur) {
        return modelMapper.map(organisateur, OrganisateurDto.class);
    }
}
