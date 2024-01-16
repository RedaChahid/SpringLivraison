package com.example.livraison.repository;

import com.example.livraison.entity.Client;
import com.example.livraison.entity.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivreurRepository extends JpaRepository<Livreur,Long> {
    List<Livreur> findByFirstName(String firstName);
}
