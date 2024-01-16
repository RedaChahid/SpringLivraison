package com.example.livraison.web;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;
import com.example.livraison.service.ClientManagerImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ClientQraphQlController {
    @Autowired
    private ClientManagerImplementation clientManagerImplementation;

    @QueryMapping
    public ClientDto getClientById(@Argument Long id){
        return clientManagerImplementation.getClientById(id);
    }
    @MutationMapping
    public  ClientDto saveClient(@Argument ClientDtoInput clientDtoInput){
        return clientManagerImplementation.saveClient(clientDtoInput);
    }

    @QueryMapping
    public List<ClientDto> getClientByName(@Argument String firstName){
        return clientManagerImplementation.getClientByName(firstName);
    }

    @MutationMapping
    public boolean deleteClient(@Argument Long id){
        return clientManagerImplementation.deleteClient(id);
    }
    @MutationMapping
    public ClientDto updateClient(@Argument Long id, @Argument ClientDtoInput clientDtoInput){
        return clientManagerImplementation.updateClient(id, clientDtoInput);
    }
    @QueryMapping
    public List<ClientDto> getAllClients(){
        return clientManagerImplementation.getAllClients();
    }

}