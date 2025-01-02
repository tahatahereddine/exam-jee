package com.ensam.donation.dao.repositories;

import com.ensam.donation.dao.entities.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
}
