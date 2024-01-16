package com.example.livraison.repository;

import com.example.livraison.entity.Client;
import com.example.livraison.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByName(String name);
}
