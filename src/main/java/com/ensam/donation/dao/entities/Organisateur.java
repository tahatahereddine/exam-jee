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
public class Organisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String email;

    @OneToMany(mappedBy= "organisateur", fetch = FetchType.EAGER)
    List<Action> actions;

}