package com.example.livraison.service;


import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.dtos.LivreurDtoInput;
import com.example.livraison.entity.Livreur;
import com.example.livraison.mappers.LivreurMapper;
import com.example.livraison.repository.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LivreurManagerImplementation implements LivreurManager {
    @Autowired
    private LivreurRepository livreurRepository;

    @Autowired
    private LivreurMapper livreurMapper;

    @Override
    public LivreurDto getLivreurById(Long id){
        return livreurMapper.fromLivreurToLivreurDto(livreurRepository.findById(id).get());
    }

    @Override
    public List<LivreurDto> getLivreurByName(String firstName){

//        List<LivreurDto> clientDtos = new ArrayList<>();
//        for (Client client : livreurRepository.findByFirstName(firstName))
//        {
//            clientDtos.add(livreurMapper.fromClientToClientDto(client));
//        }

        return  livreurRepository.findByFirstName(firstName).stream().map(livreurMapper::fromLivreurToLivreurDto)
                .collect(Collectors.toList());
    }

    @Override
    public LivreurDto saveLivreur(LivreurDtoInput livreurDtoInput){
        Livreur livreur = livreurMapper.fromLivreurDtoInputToLivreur(livreurDtoInput);
        livreur = livreurRepository.save(livreur);
        return livreurMapper.fromLivreurToLivreurDto(livreur);
    }

    @Override
    public boolean deleteLivreur(Long id) {
        livreurRepository.deleteById(id);
        return false;
    }

    @Override
    public LivreurDto updateLivreur(Long id , LivreurDtoInput livreurDtoInput){
        Livreur livreur=  livreurMapper.fromLivreurDtoToLivreur(getLivreurById(id));
        if(livreur!=null){
            livreur.setId(id);
            livreur.setFirstName(livreurDtoInput.getFirstName());
            livreur.setLastName(livreurDtoInput.getLastName());
            livreur.setTelephone(livreurDtoInput.getTelephone());
            livreur.setSalaire(livreurDtoInput.getSalaire());
            livreur.setDisponible(livreurDtoInput.isDisponible());
        }else {
            System.out.println("livreur introuvable");
        }

        return livreurMapper.fromLivreurToLivreurDto(
                livreurRepository.save(livreur)) ;
    }

    @Override
    public List<LivreurDto> getAllLivreurs(){
        return livreurRepository.findAll().stream().map(livreurMapper::fromLivreurToLivreurDto).collect(Collectors.toList());
    }

}
