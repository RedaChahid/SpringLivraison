package com.example.livraison.web;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.dtos.LivreurDtoInput;
import com.example.livraison.service.ClientManagerImplementation;
import com.example.livraison.service.LivreurManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Livreur")
@CrossOrigin
public class LivreurRestController {
    @Autowired
    LivreurManagerImplementation livreurManagerImplementation;

    @GetMapping
    public List<LivreurDto> getAllLivreurs(){
        return livreurManagerImplementation.getAllLivreurs();
    }

    @GetMapping("/livreurById/{id}")
    public LivreurDto getLivreurById(@PathVariable("id") Long id){
        return livreurManagerImplementation.getLivreurById(id);
    }


    @GetMapping("/livreursByName/{firstName}")
    public List<LivreurDto> getLivreurByName(@PathVariable("firstName") String firstName){
        return livreurManagerImplementation.getLivreurByName(firstName);
    }

    @PostMapping
    public  LivreurDto saveLivreur(@RequestBody LivreurDtoInput livreurDtoInput){
        return livreurManagerImplementation.saveLivreur(livreurDtoInput);
    }
}
