package com.example.livraison.service;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;
import com.example.livraison.entity.Client;
import com.example.livraison.mappers.ClientMapper;
import com.example.livraison.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientManagerImplementation implements ClientManager{

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public ClientDto getClientById(Long id){
        return clientMapper.fromClientToClientDto(clientRepository.findById(id).get());
    }

    @Override
    public List<ClientDto> getClientByName(String firstName){

//        List<ClientDto> clientDtos = new ArrayList<>();
//        for (Client client : clientRepository.findByFirstName(firstName))
//        {
//            clientDtos.add(clientMapper.fromClientToClientDto(client));
//        }

        return  clientRepository.findByFirstName(firstName).stream().map(clientMapper::fromClientToClientDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto saveClient(ClientDtoInput clientDtoInput){
        Client client = clientMapper.fromClientDtoInputToClient(clientDtoInput);
        client = clientRepository.save(client);
        return clientMapper.fromClientToClientDto(client);
    }

    @Override
    public boolean deleteClient(Long id) {
        clientRepository.deleteById(id);
        return false;
    }

    @Override
    public ClientDto updateClient(Long id , ClientDtoInput clientDtoInput){
        Client client=  clientMapper.fromClientDtoToClient(getClientById(id));
        if(client!=null){
            client.setId(id);
            client.setFirstName(clientDtoInput.getFirstName());
            client.setLastName(clientDtoInput.getLastName());
            client.setEmail(clientDtoInput.getEmail());
            client.setAdress(clientDtoInput.getAdress());
            client.setTelephone(clientDtoInput.getTelephone());
        }else {
            System.out.println("client introuvable");
        }

    return clientMapper.fromClientToClientDto(
            clientRepository.save(client)) ;
    }

    @Override
    public List<ClientDto> getAllClients(){
        return clientRepository.findAll().stream().map(clientMapper::fromClientToClientDto).collect(Collectors.toList());
    }
}
