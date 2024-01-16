package com.example.livraison.service;

import com.example.livraison.dtos.MagasinDto;
import com.example.livraison.dtos.MagasinDtoInput;
import com.example.livraison.entity.Magasin;
import com.example.livraison.mappers.MagasinMapper;
import com.example.livraison.repository.MagasinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component

public class MagasinManagerImplementation implements MagasinManager{
    @Autowired
    private MagasinRepository magasinRepository;
    @Autowired
    private MagasinMapper magasinMapper;

    @Override
    public MagasinDto getMagasinById(Long id){
        return magasinMapper.fromMagasinToMagasinDto(magasinRepository.findById(id).get());
    }

    @Override
    public List<MagasinDto> getMagasinByName(String firstName){

//        List<MagasinDto> magasinDtos = new ArrayList<>();
//        for (Magasin magasin : magasinRepository.findByFirstName(firstName))
//        {
//            magasinDtos.add(magasinMapper.fromMagasinToMagasinDto(magasin));
//        }

        return  magasinRepository.findByFirstName(firstName).stream().map(magasinMapper::fromMagasinToMagasinDto)
                .collect(Collectors.toList());
    }

    @Override
    public MagasinDto saveMagasin(MagasinDtoInput magasinDtoInput){
        Magasin magasin = magasinMapper.fromMagasinDtoInputToMagasin(magasinDtoInput);
        magasin = magasinRepository.save(magasin);
        return magasinMapper.fromMagasinToMagasinDto(magasin);
    }

    @Override
    public boolean deleteMagasin(Long id) {
        magasinRepository.deleteById(id);
        return false;
    }

    @Override
    public MagasinDto updateMagasin(Long id , MagasinDtoInput magasinDtoInput){
        Magasin magasin=  magasinMapper.fromMagasinDtoToMagasin(getMagasinById(id));
        if(magasin!=null){
            magasin.setId(id);
            magasin.setFirstName(magasinDtoInput.getFirstName());
            magasin.setAdress(magasinDtoInput.getAdress());
            magasin.setSurface(magasinDtoInput.getSurface());
        }else {
            System.out.println("Magasin introuvable introuvable");
        }

        return magasinMapper.fromMagasinToMagasinDto(
                magasinRepository.save(magasin)) ;
    }

    @Override
    public List<MagasinDto> getAllMagasins(){
        return magasinRepository.findAll().stream().map(magasinMapper::fromMagasinToMagasinDto).collect(Collectors.toList());
    }
}
