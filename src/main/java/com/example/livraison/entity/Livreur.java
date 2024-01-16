package com.example.livraison.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Livreur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String telephone;
    float Salaire;
    boolean disponible=true;
   @OneToMany(mappedBy = "livreur",fetch = FetchType.LAZY)
    private List<Client> clientList;

    @OneToMany(mappedBy = "livrerCommande",fetch = FetchType.EAGER)
    private  List<Commande> commandeList;

}
