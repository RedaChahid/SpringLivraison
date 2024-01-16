package com.example.livraison.service;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;

import java.util.List;

public interface ClientManager {
    public ClientDto getClientById(Long id);
    public List<ClientDto> getClientByName(String firstName);
    public List<ClientDto> getAllClients();
    public ClientDto saveClient(ClientDtoInput clientDtoInput);
    boolean deleteClient(Long id);
    public ClientDto updateClient(Long id , ClientDtoInput clientDtoInput);
}
