package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProduitDto {
    String name;
    String description;
    float prix;
}
