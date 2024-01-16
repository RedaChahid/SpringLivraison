package com.example.livraison.service;

import com.example.livraison.dtos.ProduitDto;
import com.example.livraison.dtos.ProduitDtoInput;

import java.util.List;

public interface ProduitManager {
    public ProduitDto getProduitById(Long id);
    public List<ProduitDto> getProduitByName(String name);
    public List<ProduitDto> getAllProduits();
    public ProduitDto saveProduit(ProduitDtoInput produitDtoInput);
    boolean deleteProduit(Long id);
    public ProduitDto updateProduit(Long id , ProduitDtoInput produitDtoInput);
}
