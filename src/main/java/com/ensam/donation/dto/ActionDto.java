package com.ensam.donation.dto;

import com.ensam.donation.dao.entities.EtatAction;
import com.ensam.donation.dao.entities.Organisateur;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActionDto {
    @Size(min=2, message = "Le titre doit être plus de 2 caractères")
    private String titre;
    @Size(min=2, message = "La description doit être plus de 2 caractères")
    private String description;
    @NotNull(message = "La date de création ne doit pas être vide")
    private LocalDate dateDeCreation;
    @NotNull(message = "Le montant ne doit pas être vide")
    @Min(value = 0, message = "Le montant doit être positif")
    private Integer montant;
    @NotNull(message = "L'état ne doit pas être vide")
    private EtatAction etat;

    Organisateur organisateur;
    List<DonDto> dons;

}
