package com.example.livraison.web;

import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.dtos.LivreurDtoInput;
import com.example.livraison.service.LivreurManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LivreurGraphQlController {

    @Autowired
    private LivreurManagerImplementation livreurManagerImplementation;

    @QueryMapping
    public LivreurDto getLivreurById(@Argument Long id){
        return livreurManagerImplementation.getLivreurById(id);
    }
    @MutationMapping
    public  LivreurDto saveLivreur(@Argument LivreurDtoInput livreurDtoInput){

        return livreurManagerImplementation.saveLivreur(livreurDtoInput);
    }

    @QueryMapping
    public List<LivreurDto> getLivreurByName(@Argument String firstName){
        return livreurManagerImplementation.getLivreurByName(firstName);
    }

    @MutationMapping
    public boolean deleteLivreur(@Argument Long id){
        return livreurManagerImplementation.deleteLivreur(id);
    }
    @MutationMapping
    public LivreurDto updateLivreur(@Argument Long id, @Argument LivreurDtoInput livreurDtoInput){
        return livreurManagerImplementation.updateLivreur(id, livreurDtoInput);
    }
    @QueryMapping
    public List<LivreurDto> getAllLivreurs(){
        return livreurManagerImplementation.getAllLivreurs();
    }
}
