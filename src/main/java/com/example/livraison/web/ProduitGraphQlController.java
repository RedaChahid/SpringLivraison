package com.example.livraison.web;

import com.example.livraison.dtos.ProduitDto;
import com.example.livraison.dtos.ProduitDtoInput;
import com.example.livraison.service.ProduitManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProduitGraphQlController {
    @Autowired
    private ProduitManagerImplementation produitManagerImplementation;

    @QueryMapping
    public ProduitDto getProduitById(@Argument Long id){
        return produitManagerImplementation.getProduitById(id);
    }
    @MutationMapping
    public  ProduitDto saveProduit(@Argument ProduitDtoInput produitDtoInput){

        return produitManagerImplementation.saveProduit(produitDtoInput);
    }

    @QueryMapping
    public List<ProduitDto> getProduitByName(@Argument String name){
        return produitManagerImplementation.getProduitByName(name);
    }

    @MutationMapping
    public boolean deleteProduit(@Argument Long id){
        return produitManagerImplementation.deleteProduit(id);
    }
    @MutationMapping
    public ProduitDto updateProduit(@Argument Long id, @Argument ProduitDtoInput produitDtoInput){
        return produitManagerImplementation.updateProduit(id, produitDtoInput);
    }
    @QueryMapping
    public List<ProduitDto> getAllProduits(){
        return produitManagerImplementation.getAllProduits();
    }


}
