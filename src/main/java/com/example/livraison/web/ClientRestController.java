package com.example.livraison.web;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;
import com.example.livraison.dtos.CommandeDto;
import com.example.livraison.entity.Client;
import com.example.livraison.service.ClientManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin
public class ClientRestController {
    @Autowired
    ClientManagerImplementation clientManagerImplementation;

    @GetMapping
    public List<ClientDto> getAllClients(){
        return clientManagerImplementation.getAllClients();
    }

    @GetMapping("/clientById/{id}")
    public ClientDto getClientById(@PathVariable("id") Long id){
        return clientManagerImplementation.getClientById(id);
    }

    @GetMapping("/clientsByName/{firstName}")
    public List<ClientDto> getClientByName(@PathVariable("firstName") String firstName){
        return clientManagerImplementation.getClientByName(firstName);
    }

        @PostMapping
    public  ClientDto saveClient(@RequestBody ClientDtoInput clientDtoInput){
        return clientManagerImplementation.saveClient(clientDtoInput);
    }

}
