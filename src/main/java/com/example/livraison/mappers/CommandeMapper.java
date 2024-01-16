package com.example.livraison.mappers;

import com.example.livraison.dtos.CommandeDto;
import com.example.livraison.dtos.CommandeDtoInput;
import com.example.livraison.entity.Commande;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CommandeMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Commande fromCommandeDtoToCommande(CommandeDto commandeDto) {
        return this.modelMapper.map(commandeDto, Commande.class);
    }
    public CommandeDto fromCommandeToCommandeDto(Commande commande) {
        return this.modelMapper.map(commande, CommandeDto.class);
    }
    public CommandeDtoInput fromCommandeDtoToCommandeDtoInput(CommandeDto produitDto) {
        return this.modelMapper.map(produitDto, CommandeDtoInput.class);
    }
    public CommandeDto fromCommandeDtoInputToCommandeDto(CommandeDtoInput commandeDtoInput) {
        return this.modelMapper.map(commandeDtoInput, CommandeDto.class);
    }
    public Commande fromCommandeDtoInputToCommande(CommandeDtoInput commandeDtoInput) {
        return this.modelMapper.map(commandeDtoInput, Commande.class);
    }
}