package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MagasinDtoInput {
    String firstName;
    String adress;
    float surface;
}
