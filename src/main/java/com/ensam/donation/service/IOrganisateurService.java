package com.ensam.donation.service;

import com.ensam.donation.dto.OrganisateurDto;

import java.util.List;

public interface IOrganisateurService {
    OrganisateurDto addOrganisateur(OrganisateurDto organisateurDto);
    List<OrganisateurDto> getOrganisateurs();
    OrganisateurDto getOrganisateurById(Integer id);
    OrganisateurDto updateOrganisateur(Integer id, OrganisateurDto organisateurDto);
    void deleteOrganisateur(Integer id);
}
