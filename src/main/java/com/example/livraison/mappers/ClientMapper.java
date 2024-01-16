package com.example.livraison.mappers;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;
import com.example.livraison.entity.Client;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Client fromClientDtoToClient(ClientDto clientDto) {
        return this.modelMapper.map(clientDto, Client.class);
    }
    public ClientDto fromClientToClientDto(Client client) {
        return this.modelMapper.map(client, ClientDto.class);
    }
    public ClientDtoInput fromClientDtoToClientDtoInput(ClientDto clientDto) {
        return this.modelMapper.map(clientDto, ClientDtoInput.class);
    }
    public ClientDto fromClientDtoInputToClientDto(ClientDtoInput clientDtoInput) {
        return this.modelMapper.map(clientDtoInput, ClientDto.class);
    }
    public Client fromClientDtoInputToClient(ClientDtoInput clientDtoInput) {
        return this.modelMapper.map(clientDtoInput, Client.class);
    }

}
