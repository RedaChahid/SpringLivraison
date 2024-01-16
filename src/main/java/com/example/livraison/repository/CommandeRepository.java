package com.example.livraison.repository;

import com.example.livraison.entity.Commande;
import com.example.livraison.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
    List<Commande> findByName(String name);

}
