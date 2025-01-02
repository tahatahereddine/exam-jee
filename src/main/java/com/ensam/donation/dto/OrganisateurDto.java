package com.ensam.donation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganisateurDto {
    @NotNull(message = "Le nom ne doit pas être vide")
    @Size(min = 2, message = "Le nom doit être plus de 2 caractères")
    private String nom;

    @NotNull(message = "L'email ne doit pas être vide")
    @Email(message = "L'email doit être valide")
    private String email;

    private List<ActionDto> actions;
}
