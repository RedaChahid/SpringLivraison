package com.example.livraison.service;

import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;
import com.example.livraison.dtos.MagasinDto;
import com.example.livraison.dtos.MagasinDtoInput;

import java.util.List;

public interface MagasinManager {
    public MagasinDto getMagasinById(Long id);
    public List<MagasinDto> getMagasinByName(String firstName);
    public List<MagasinDto> getAllMagasins();
    public MagasinDto saveMagasin(MagasinDtoInput magasinDtoInput);
    boolean deleteMagasin(Long id);
    public MagasinDto updateMagasin(Long id , MagasinDtoInput magasinDtoInput);
}
