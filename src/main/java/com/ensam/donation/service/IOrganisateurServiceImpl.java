package com.ensam.donation.service;

import com.ensam.donation.dao.entities.Organisateur;
import com.ensam.donation.dao.repositories.OrganisateurRepository;
import com.ensam.donation.dto.OrganisateurDto;
import com.ensam.donation.mapper.OrganisateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IOrganisateurServiceImpl implements IOrganisateurService {

    @Autowired
    private OrganisateurRepository organisateurRepository;
    @Autowired
    private OrganisateurMapper organisateurMapper;

    @Override
    public OrganisateurDto addOrganisateur(OrganisateurDto organisateurDto) {
        Organisateur organisateur = organisateurMapper.fromOrganisateurDtoToOrganisateur(organisateurDto);
        Organisateur savedOrganisateur = organisateurRepository.save(organisateur);
        return organisateurMapper.fromOrganisateurToOrganisateurDto(savedOrganisateur);
    }

    @Override
    public List<OrganisateurDto> getOrganisateurs() {
        List<Organisateur> organisateurs = organisateurRepository.findAll();
        return organisateurs.stream().map(organisateurMapper::fromOrganisateurToOrganisateurDto).toList();
    }

    @Override
    public OrganisateurDto getOrganisateurById(Integer id) {
        Organisateur organisateur = organisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organisateur not found with id: " + id));
        return organisateurMapper.fromOrganisateurToOrganisateurDto(organisateur);
    }

    @Override
    public OrganisateurDto updateOrganisateur(Integer id, OrganisateurDto organisateurDto) {
        Organisateur organisateur = organisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organisateur not found with id: " + id));
        organisateur.setNom(organisateurDto.getNom());
        organisateur.setEmail(organisateurDto.getEmail());
        Organisateur updatedOrganisateur = organisateurRepository.save(organisateur);
        return organisateurMapper.fromOrganisateurToOrganisateurDto(updatedOrganisateur);
    }

    @Override
    public void deleteOrganisateur(Integer id) {
        Organisateur organisateur = organisateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organisateur not found with id: " + id));
        organisateurRepository.delete(organisateur);
    }
}
