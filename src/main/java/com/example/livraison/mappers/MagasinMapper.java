package com.example.livraison.mappers;


import com.example.livraison.dtos.MagasinDto;
import com.example.livraison.dtos.MagasinDtoInput;
import com.example.livraison.entity.Magasin;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component

public class MagasinMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Magasin fromMagasinDtoToMagasin(MagasinDto magasinDto) {
        return this.modelMapper.map(magasinDto, Magasin.class);
    }
    public MagasinDto fromMagasinToMagasinDto(Magasin magasin) {
        return this.modelMapper.map(magasin, MagasinDto.class);
    }
    public MagasinDtoInput fromMagasinDtoToMagasinDtoInput(MagasinDto magasinDto) {
        return this.modelMapper.map(magasinDto, MagasinDtoInput.class);
    }
    public MagasinDto fromMagasinDtoInputToMagasinDto(MagasinDtoInput magasinDtoInput) {
        return this.modelMapper.map(magasinDtoInput, MagasinDto.class);
    }
    public Magasin fromMagasinDtoInputToMagasin(MagasinDtoInput magasinDtoInput) {
        return this.modelMapper.map(magasinDtoInput, Magasin.class);
    }
}
