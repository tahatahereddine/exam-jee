package com.ensam.donation.service;

import com.ensam.donation.dao.entities.Donateur;
import com.ensam.donation.dao.repositories.DonateurRepository;
import com.ensam.donation.dto.DonateurDto;
import com.ensam.donation.mapper.DonateurMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDonateurServiceImpl implements IDonateurService {

    @Autowired
    private DonateurRepository donateurRepository;
    @Autowired
    private DonateurMapper donateurMapper;

    @Override
    public DonateurDto addDonateur(DonateurDto donateurDto) {
        Donateur donateur = donateurMapper.fromDonateurDtoToDonateur(donateurDto);
        Donateur savedDonateur = donateurRepository.save(donateur);
        return donateurMapper.fromDonateurToDonateurDto(savedDonateur);
    }

    @Override
    public List<DonateurDto> getDonateurs() {
        List<Donateur> donateurs = donateurRepository.findAll();
        return donateurs.stream().map(donateurMapper::fromDonateurToDonateurDto).toList();
    }

    @Override
    public DonateurDto getDonateurById(Integer id) {
        Donateur donateur = donateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donateur not found with id: " + id));
        return donateurMapper.fromDonateurToDonateurDto(donateur);
    }

    @Override
    public DonateurDto updateDonateur(Integer id, DonateurDto donateurDto) {
        Donateur donateur = donateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donateur not found with id: " + id));
        donateur.setNom(donateurDto.getNom());
        donateur.setPrenom(donateurDto.getPrenom());
        donateur.setEvaluation(donateurDto.getEvaluation());
        Donateur updatedDonateur = donateurRepository.save(donateur);
        return donateurMapper.fromDonateurToDonateurDto(updatedDonateur);
    }

    @Override
    public void deleteDonateur(Integer id) {
        Donateur donateur = donateurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Donateur not found with id: " + id));
        donateurRepository.delete(donateur);
    }
}
