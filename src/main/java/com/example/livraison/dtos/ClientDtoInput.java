package com.example.livraison.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientDtoInput {
    private String firstName;
    private String lastName;
    private String telephone;
    private String adress;
    private String email;
}
