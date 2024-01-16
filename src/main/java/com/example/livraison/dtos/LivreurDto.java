package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LivreurDto {
    private String firstName;
    private String lastName;
    private String telephone;

    float Salaire;
    boolean disponible=false;
}
