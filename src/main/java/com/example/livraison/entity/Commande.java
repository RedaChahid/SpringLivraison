package com.example.livraison.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    float montant;

    @OneToMany(mappedBy = "commandeProduits")
    private Collection<Produit> produitCollection ;

    @ManyToOne
    private Client client;
    @ManyToOne
    private  Livreur livrerCommande;

}
