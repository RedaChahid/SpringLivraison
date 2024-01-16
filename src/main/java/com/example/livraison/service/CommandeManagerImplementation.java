package com.example.livraison.service;

import com.example.livraison.dtos.CommandeDto;
import com.example.livraison.dtos.CommandeDtoInput;
import com.example.livraison.entity.Client;
import com.example.livraison.entity.Commande;
import com.example.livraison.mappers.CommandeMapper;
import com.example.livraison.repository.ClientRepository;
import com.example.livraison.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommandeManagerImplementation implements CommandeManager{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private CommandeMapper commandeMapper;

    @Override
    public CommandeDto getCommandeById(Long id){
        return commandeMapper.fromCommandeToCommandeDto(commandeRepository.findById(id).get());
    }

    @Override
    public List<CommandeDto> getCommandeByName(String name){

//        List<CommandeDto> commandeDtos = new ArrayList<>();
//        for (Produit produit : commandeRepository.findByName(name))
//        {
//            produitDtos.add(commandeMapper.fromProduitToProduitDto(produit));
//        }

        return  commandeRepository.findByName(name).stream().map(commandeMapper::fromCommandeToCommandeDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommandeDto saveCommande(CommandeDtoInput commandeDtoInput ){
        Client client = clientRepository.findById(commandeDtoInput.getId_client()).get();
        if (client==null){
            throw new RuntimeException();
        }

        Commande commande = commandeMapper.fromCommandeDtoInputToCommande(commandeDtoInput);
        commande.setClient(client);
        commande = commandeRepository.save(commande);
        return commandeMapper.fromCommandeToCommandeDto(commande);
    }

    @Override
    public boolean deleteCommande(Long id) {
        commandeRepository.deleteById(id);
        return false;
    }

    @Override
    public List<CommandeDto> getAllCommandes(){
        return commandeRepository.findAll().stream().map(commandeMapper::fromCommandeToCommandeDto).collect(Collectors.toList());
    }

}
