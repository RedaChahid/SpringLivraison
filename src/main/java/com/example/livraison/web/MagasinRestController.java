package com.example.livraison.web;

import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.dtos.MagasinDto;
import com.example.livraison.dtos.MagasinDtoInput;
import com.example.livraison.service.MagasinManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Magasin")
@CrossOrigin
public class MagasinRestController {

    @Autowired
    MagasinManagerImplementation magasinManagerImplementation;

    @GetMapping
    public List<MagasinDto> getAllMagasins(){
        return magasinManagerImplementation.getAllMagasins();
    }

    @GetMapping("/magasinById/{id}")
    public MagasinDto getMagasinById(@PathVariable("id") Long id){
        return magasinManagerImplementation.getMagasinById(id);
    }
    @GetMapping("/magasinsByName/{firstName}")
    public List<MagasinDto> getMagasinByName(@PathVariable("firstName") String firstName){
        return magasinManagerImplementation.getMagasinByName(firstName);
    }

    @PostMapping
    public  MagasinDto saveMagasin(@RequestBody MagasinDtoInput magasinDtoInput){

        return magasinManagerImplementation.saveMagasin(magasinDtoInput);
    }
}
