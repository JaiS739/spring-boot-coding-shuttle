package com.codingshuttle.restpractice.restPractice.service;

import com.codingshuttle.restpractice.restPractice.dto.AnimalDto;
import com.codingshuttle.restpractice.restPractice.entities.AnimalEntity;
import com.codingshuttle.restpractice.restPractice.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final ModelMapper modelMapper;

    public AnimalService(AnimalRepository animalRepository, ModelMapper modelMapper){
        this.animalRepository = animalRepository;
        this.modelMapper = modelMapper;
    }

    public List<AnimalDto> getAllEmployee(){
        List<AnimalEntity> animalEntities = animalRepository.findAll();

        return animalEntities
                .stream()
                .map(animalEntity -> modelMapper.map(animalEntity, AnimalDto.class))
                .collect(Collectors.toList());
    }

}
