package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommandeDtoInput {
    Long id_client;
    String name;
    float montant;
}
