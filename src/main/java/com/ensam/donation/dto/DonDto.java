package com.ensam.donation.dto;

import com.ensam.donation.dao.entities.TypeDon;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DonDto {
    @Size(min=2, message = "Le titre doit être plus de 2 caractères")
    private String titre;

    @NotNull(message = "Le montant ne doit pas être vide")
    @Min(value = 0, message = "Le montant doit être positif")
    private Integer montant;

    @NotNull(message = "Le type de don ne doit pas être vide")
    private TypeDon type;

    private ActionDto action;

    private DonateurDto donateur;
}

