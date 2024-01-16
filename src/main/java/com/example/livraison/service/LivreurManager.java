package com.example.livraison.service;


import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.dtos.LivreurDtoInput;

import java.util.List;

public interface LivreurManager {
    public LivreurDto getLivreurById(Long id);
    public List<LivreurDto> getLivreurByName(String firstName);
    public List<LivreurDto> getAllLivreurs();
    public LivreurDto saveLivreur(LivreurDtoInput livreurDtoInput);
    boolean deleteLivreur(Long id);
    public LivreurDto updateLivreur(Long id , LivreurDtoInput livreurDtoInput);
}
