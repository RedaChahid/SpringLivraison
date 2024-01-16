package com.example.livraison.service;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ProduitDto;
import com.example.livraison.dtos.ProduitDtoInput;
import com.example.livraison.entity.Produit;
import com.example.livraison.mappers.ProduitMapper;
import com.example.livraison.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProduitManagerImplementation implements ProduitManager{
    @Autowired
    private ProduitRepository produitRepository;
    @Autowired
    private ProduitMapper produitMapper;

    @Override
    public ProduitDto getProduitById(Long id){
        return produitMapper.fromProduitToProduitDto(produitRepository.findById(id).get());
    }

    @Override
    public List<ProduitDto> getProduitByName(String name){

//        List<ProduitDto> produitDtos = new ArrayList<>();
//        for (Produit produit : produitRepository.findByName(name))
//        {
//            produitDtos.add(produitMapper.fromProduitToProduitDto(produit));
//        }

        return  produitRepository.findByName(name).stream().map(produitMapper::fromProduitToProduitDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProduitDto saveProduit(ProduitDtoInput produitDtoInput){
        Produit produit = produitMapper.fromProduitDtoInputToProduit(produitDtoInput);
        produit = produitRepository.save(produit);
        return produitMapper.fromProduitToProduitDto(produit);
    }

    @Override
    public boolean deleteProduit(Long id) {
        produitRepository.deleteById(id);
        return false;
    }

    @Override
    public ProduitDto updateProduit(Long id , ProduitDtoInput produitDtoInput){
        Produit produit=  produitMapper.fromProduitDtoToProduit(getProduitById(id));
        if(produit!=null){
            produit.setId(id);
            produit.setName(produitDtoInput.getName());
            produit.setDescription(produitDtoInput.getDescription());
            produit.setPrix(produitDtoInput.getPrix());

        }else {
            System.out.println("client introuvable");
        }

        return produitMapper.fromProduitToProduitDto(
                produitRepository.save(produit)) ;
    }

    @Override
    public List<ProduitDto> getAllProduits(){
        return produitRepository.findAll().stream().map(produitMapper::fromProduitToProduitDto).collect(Collectors.toList());
    }
}
