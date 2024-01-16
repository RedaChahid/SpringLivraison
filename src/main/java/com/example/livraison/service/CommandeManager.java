package com.example.livraison.service;

import com.example.livraison.dtos.CommandeDto;
import com.example.livraison.dtos.CommandeDtoInput;

import java.util.List;

public interface CommandeManager {
    public CommandeDto getCommandeById(Long id);
    public List<CommandeDto> getCommandeByName(String name);
    public List<CommandeDto> getAllCommandes();
    public CommandeDto saveCommande(CommandeDtoInput commandeDtoInput);
    boolean deleteCommande(Long id);

}
