package com.ensam.donation.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Donateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private EvaluationDonateur evaluation;

    @OneToMany(mappedBy= "donateur", fetch = FetchType.EAGER)
    List<Don> dons;

}
