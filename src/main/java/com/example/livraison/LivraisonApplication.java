package com.example.livraison;

import com.example.livraison.entity.*;
import com.example.livraison.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LivraisonApplication {

    public static void main(String[] args) {
        SpringApplication.run(LivraisonApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ClientRepository clientRepository , LivreurRepository livreurRepository, MagasinRepository magasinRepository , ProduitRepository produitRepository , CommandeRepository commandeRepository) {
        return args -> {

            List<Livreur> livreurList =  List.of(
                    Livreur.builder().firstName("ahmed").lastName("semraoui").telephone("0798574632").Salaire(2500).build(),
                    Livreur.builder().firstName("hamid").lastName("abdo").telephone("0678452154").Salaire(3000).build(),
                    Livreur.builder().firstName("hatim").lastName("moutamid").telephone("0775483215").Salaire(3500).build(),
                    Livreur.builder().firstName("adam").lastName("laalawi").telephone("0796485714").Salaire(2500).build()
            );

            livreurRepository.saveAll(livreurList);
            List<Client> clientList =  List.of(
                    Client.builder().firstName("ahmed").lastName("semraoui").telephone("0798574632").adress("Place des Nations-Unies, Boulevard Rachidi, Casablanca 20250").email("reda@gmail.com").build(),
                    Client.builder().firstName("hamid").lastName("abdo").telephone("0678452154").adress("Parc de Mohammedia، 38, Résidence Nour Chourouk, Parc Mohammedia, BP 28830, Mohammedia 28830").email("mehdi@gmail.com").build(),
                    Client.builder().firstName("hatim").lastName("moutamid").telephone("0775483215").adress("Hôtel du Golf Mohammedia, et Boutaleb، Angle Rue Ibn Toumert, Mohammédia 28810").email("saad@gmail.com").build(),
                    Client.builder().firstName("adam").lastName("laalawi").telephone("0796485714").adress("Musée du Louvre, 75001 Paris, France").email("mohammed@gmail.com").build()
            );
            clientRepository.saveAll(clientList);

            List<Magasin> MagasinList =  List.of(
                    Magasin.builder().firstName("Marjan").adress("Place des Nations-Unies, Boulevard Rachidi, Casablanca 20250").surface(35600).build(),
                    Magasin.builder().firstName("Bim").adress("Parc de Mohammedia، 38, Résidence Nour Chourouk, Parc Mohammedia, BP 28830, Mohammedia 28830").surface(65500).build(),
                    Magasin.builder().firstName("Label Vie").adress("Hôtel du Golf Mohammedia, et Boutaleb، Angle Rue Ibn Toumert, Mohammédia 28810").surface(20000).build(),
                    Magasin.builder().firstName("Aswak Salam").adress("Musée du Louvre, 75001 Paris, France").surface(15000).build()
            );
            magasinRepository.saveAll(MagasinList);

            List<Produit> ProduitList =  List.of(
                    Produit.builder().name("Tonic").description("Une delicieuse pasta").prix(2).build(),
                    Produit.builder().name("Merondina").description("Une delicieux biscuit").prix(2).build(),
                    Produit.builder().name("Pringels").description("Une Chips crunchy").prix(22).build()
            );
            produitRepository.saveAll(ProduitList);

            List<Commande> CommandeList =  List.of(
                    Commande.builder().name("Commande 1").montant(250).client(clientList.get(1)).build(),
                    Commande.builder().name("Commande 2").montant(350).build(),
                    Commande.builder().name("Commande 3").montant(450).build()
            );
            commandeRepository.saveAll(CommandeList);
        };
    }
}