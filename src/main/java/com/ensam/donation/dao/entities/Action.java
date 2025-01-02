package com.ensam.donation.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private String description;
    private LocalDate dateDeCreation;
    private Integer montant;
    private EtatAction etat;

    @ManyToOne
    Organisateur organisateur;
    @OneToMany(mappedBy= "action", fetch = FetchType.EAGER)
    List<Don> dons;

}
