package com.example.livraison.web;

import com.example.livraison.dtos.CommandeDto;
import com.example.livraison.dtos.CommandeDtoInput;
import com.example.livraison.service.CommandeManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CommandeGraphQlController {
    @Autowired
    private CommandeManagerImplementation commandeManagerImplementation;

    @QueryMapping
    public CommandeDto getCommandeById(@Argument Long id){
        return commandeManagerImplementation.getCommandeById(id);
    }

    @MutationMapping
    public CommandeDto saveCommande(@Argument CommandeDtoInput commandeDtoInput){

        return commandeManagerImplementation.saveCommande(commandeDtoInput);
    }

    @QueryMapping
    public List<CommandeDto> getCommandeByName(@Argument String name){
        return commandeManagerImplementation.getCommandeByName(name);
    }

    @MutationMapping
    public boolean deleteCommande(@Argument Long id){
        return commandeManagerImplementation.deleteCommande(id);
    }
    @QueryMapping
    public List<CommandeDto> getAllCommandes(){
        return commandeManagerImplementation.getAllCommandes();
    }
}
