package com.ensam.donation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.ensam.donation.dao.repositories.ActionRepository;
import com.ensam.donation.dao.repositories.DonateurRepository;
import com.ensam.donation.dao.repositories.OrganisateurRepository;
import com.ensam.donation.dao.repositories.DonRepository;

@SpringBootApplication
public class DonationApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DonationApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            DonateurRepository donateurRepository,
            ActionRepository actionRepository,
            OrganisateurRepository organisateurRepository,
            DonRepository donRepository
    ) {
        return args -> {

        };
    }

}
