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
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstName;
    String lastName;
    String telephone;
    String adress;
    String email;
    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<Commande> commandeList;

    @ManyToOne
    private Livreur livreur;

}
