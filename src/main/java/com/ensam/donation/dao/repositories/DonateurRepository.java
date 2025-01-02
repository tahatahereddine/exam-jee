package com.ensam.donation.dao.repositories;

import com.ensam.donation.dao.entities.Donateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateurRepository extends JpaRepository<Donateur, Integer> {
}
