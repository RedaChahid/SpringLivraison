package com.example.livraison.web;

import com.example.livraison.dtos.MagasinDto;
import com.example.livraison.dtos.MagasinDtoInput;
import com.example.livraison.service.MagasinManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MagasinGraphQlController {

    @Autowired
    private MagasinManagerImplementation magasinManagerImplementation;

    @QueryMapping
    public MagasinDto getMagasinById(@Argument Long id){
        return magasinManagerImplementation.getMagasinById(id);
    }
    @MutationMapping
    public  MagasinDto saveMagasin(@Argument MagasinDtoInput magasinDtoInput){

        return magasinManagerImplementation.saveMagasin(magasinDtoInput);
    }

    @QueryMapping
    public List<MagasinDto> getMagasinByName(@Argument String firstName){
        return magasinManagerImplementation.getMagasinByName(firstName);
    }

    @MutationMapping
    public boolean deleteMagasin(@Argument Long id){
        return magasinManagerImplementation.deleteMagasin(id);
    }
    @MutationMapping
    public MagasinDto updateMagasin(@Argument Long id, @Argument MagasinDtoInput magasinDtoInput){
        return magasinManagerImplementation.updateMagasin(id, magasinDtoInput);
    }
    @QueryMapping
    public List<MagasinDto> getAllMagasins(){
        return magasinManagerImplementation.getAllMagasins();
    }

}
