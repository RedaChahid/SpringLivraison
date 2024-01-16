package com.example.livraison.mappers;

import com.example.livraison.dtos.ProduitDto;
import com.example.livraison.dtos.ProduitDtoInput;
import com.example.livraison.entity.Client;
import com.example.livraison.entity.Produit;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProduitMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Produit fromProduitDtoToProduit(ProduitDto produitDto) {
        return this.modelMapper.map(produitDto, Produit.class);
    }
    public ProduitDto fromProduitToProduitDto(Produit produit) {
        return this.modelMapper.map(produit, ProduitDto.class);
    }
    public ProduitDtoInput fromProduitDtoToProduitDtoInput(ProduitDto produitDto) {
        return this.modelMapper.map(produitDto, ProduitDtoInput.class);
    }
    public ProduitDto fromProduitDtoInputToProduitDto(ProduitDtoInput produitDtoInput) {
        return this.modelMapper.map(produitDtoInput, ProduitDto.class);
    }
    public Produit fromProduitDtoInputToProduit(ProduitDtoInput produitDtoInput) {
        return this.modelMapper.map(produitDtoInput, Produit.class);
    }

}
