package com.ensam.donation.dao.entities;

import jakarta.persistence.*;
import lombok.*;


@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titre;
    private Integer montant;
    private TypeDon type;

    @ManyToOne
    Action action;

    @ManyToOne
    Donateur donateur;


}
