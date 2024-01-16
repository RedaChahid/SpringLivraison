package com.example.livraison.web;

import com.example.livraison.dtos.CommandeDto;
import com.example.livraison.dtos.CommandeDtoInput;
import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.service.CommandeManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Commande")
@CrossOrigin
public class CommandeRestController {
    @Autowired
    CommandeManagerImplementation commandeManagerImplementation;
    @GetMapping
    public List<CommandeDto> getAllCommandes(){
        return commandeManagerImplementation.getAllCommandes();
    }

    @GetMapping("/commandeById/{id}")
    public CommandeDto getCommandeById(@PathVariable("id") Long id){
        return commandeManagerImplementation.getCommandeById(id);
    }
    @GetMapping("/commandesByName/{name}")
    public List<CommandeDto> getCommandeByName(@PathVariable("name") String name){
        return commandeManagerImplementation.getCommandeByName(name);
    }
    @PostMapping
    public CommandeDto saveCommande(@RequestBody CommandeDtoInput commandeDtoInput) {
        return commandeManagerImplementation.saveCommande(commandeDtoInput);
    }
    }
