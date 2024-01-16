package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProduitDtoInput {
    String name;
    String description;
    float prix;
}
