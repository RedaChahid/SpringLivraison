package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LivreurDtoInput {
    private String firstName;
    private String lastName;
    private String telephone;
    float Salaire;
    boolean disponible=false;
}
