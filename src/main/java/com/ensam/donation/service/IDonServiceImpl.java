package com.ensam.donation.service;

import com.ensam.donation.dao.entities.Don;
import com.ensam.donation.dao.repositories.DonRepository;
import com.ensam.donation.dto.DonDto;
import com.ensam.donation.mapper.DonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDonServiceImpl implements IDonService {

    @Autowired
    private DonRepository donRepository;
    @Autowired
    private DonMapper donMapper;

    @Override
    public DonDto addDon(DonDto donDto) {
        Don don = donMapper.fromDonDtoToDon(donDto);
        Don savedDon = donRepository.save(don);
        return donMapper.fromDonToDonDto(savedDon);
    }

    @Override
    public List<DonDto> getDons() {
        List<Don> dons = donRepository.findAll();
        return dons.stream().map(donMapper::fromDonToDonDto).toList();
    }

    @Override
    public DonDto getDonById(Integer id) {
        Don don = donRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Don not found with id: " + id));
        return donMapper.fromDonToDonDto(don);
    }

    @Override
    public DonDto updateDon(Integer id, DonDto donDto) {
        Don don = donRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Don not found with id: " + id));
        don.setTitre(donDto.getTitre());
        don.setMontant(donDto.getMontant());
        don.setType(donDto.getType());
        Don updatedDon = donRepository.save(don);
        return donMapper.fromDonToDonDto(updatedDon);
    }

    @Override
    public void deleteDon(Integer id) {
        Don don = donRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Don not found with id: " + id));
        donRepository.delete(don);
    }
}
