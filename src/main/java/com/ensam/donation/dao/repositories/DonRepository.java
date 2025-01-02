package com.ensam.donation.dao.repositories;

import com.ensam.donation.dao.entities.Don;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonRepository extends JpaRepository<Don, Integer> {
}
