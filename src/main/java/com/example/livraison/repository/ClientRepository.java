package com.example.livraison.repository;

import com.example.livraison.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
public interface ClientRepository extends JpaRepository<Client,Long> {
    List<Client> findByFirstName(String firstName);

}
