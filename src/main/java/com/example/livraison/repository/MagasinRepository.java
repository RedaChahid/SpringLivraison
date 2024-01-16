package com.example.livraison.repository;

import com.example.livraison.entity.Client;
import com.example.livraison.entity.Magasin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagasinRepository extends JpaRepository<Magasin,Long> {
    List<Magasin> findByFirstName(String firstName);
}
