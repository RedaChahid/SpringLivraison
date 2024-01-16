package com.example.livraison.mappers;
import com.example.livraison.dtos.ClientDto;
import com.example.livraison.dtos.ClientDtoInput;
import com.example.livraison.dtos.LivreurDto;
import com.example.livraison.dtos.LivreurDtoInput;
import com.example.livraison.entity.Client;
import com.example.livraison.entity.Livreur;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LivreurMapper {
    private ModelMapper modelMapper = new ModelMapper();
    public Livreur fromLivreurDtoToLivreur(LivreurDto livreurDto) {
        return this.modelMapper.map(livreurDto, Livreur.class);
    }
    public LivreurDto fromLivreurToLivreurDto(Livreur livreur) {
        return this.modelMapper.map(livreur, LivreurDto.class);
    }
    public LivreurDtoInput fromLivreurDtoToLivreurDtoInput(LivreurDto livreurDto) {
        return this.modelMapper.map(livreurDto, LivreurDtoInput.class);
    }
    public LivreurDto fromLivreurDtoInputToLivreurDto(LivreurDtoInput livreurDtoInput) {
        return this.modelMapper.map(livreurDtoInput, LivreurDto.class);
    }
    public Livreur fromLivreurDtoInputToLivreur(LivreurDtoInput livreurDtoInput) {
        return this.modelMapper.map(livreurDtoInput, Livreur.class);
    }
}
