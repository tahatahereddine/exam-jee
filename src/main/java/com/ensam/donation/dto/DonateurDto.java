package com.ensam.donation.dto;

import com.ensam.donation.dao.entities.EvaluationDonateur;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonateurDto {
    @NotNull(message = "Le nom ne doit pas être vide")
    @Size(min = 2, message = "Le nom doit être plus de 2 caractères")
    private String nom;

    @NotNull(message = "Le prénom ne doit pas être vide")
    @Size(min = 2, message = "Le prénom doit être plus de 2 caractères")
    private String prenom;

    @NotNull(message = "L'évaluation ne doit pas être vide")
    private EvaluationDonateur evaluation;

    private List<DonDto> dons;
}
