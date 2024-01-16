package com.example.livraison.web;

import com.example.livraison.dtos.ProduitDto;
import com.example.livraison.dtos.ProduitDtoInput;
import com.example.livraison.service.ProduitManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Produit")
@CrossOrigin
public class ProduitRestController {
    @Autowired
    ProduitManagerImplementation produitManagerImplementation;
    @GetMapping
    public List<ProduitDto> getAllProduits(){
        return produitManagerImplementation.getAllProduits();
    }


    @GetMapping("/produitById/{id}")
    public ProduitDto getProduitById(@PathVariable("id") Long id){
        return produitManagerImplementation.getProduitById(id);
    }
    @GetMapping("/produitsByName/{name}")
    public List<ProduitDto> getProduitByName(@PathVariable("name") String name){
        return produitManagerImplementation.getProduitByName(name);
    }
    @PostMapping
    public  ProduitDto saveProduit(@RequestBody ProduitDtoInput produitDtoInput){

        return produitManagerImplementation.saveProduit(produitDtoInput);
    }

}
