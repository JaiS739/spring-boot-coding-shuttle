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

    public boolean animalExists(Long id){
        return animalRepository.existsById(id);
    }

    public List<AnimalDto> getAllEmployee(){
        List<AnimalEntity> animalEntities = animalRepository.findAll();

        return animalEntities
                .stream()
                .map(animalEntity -> modelMapper.map(animalEntity, AnimalDto.class))
                .collect(Collectors.toList());
    }

    public AnimalDto createAnimal (AnimalDto inputValue){
        AnimalEntity toSaveEntity = modelMapper.map(inputValue, AnimalEntity.class);
        AnimalEntity savedEntity = animalRepository.save(toSaveEntity);
        return modelMapper.map(savedEntity, AnimalDto.class);
    }

    public AnimalDto updateAnimalById (Long animalId, AnimalDto inputValue){
        AnimalEntity existing = animalRepository.findById(animalId)
                .orElseThrow(() -> new RuntimeException("animal does not exist"));
        existing.setName(inputValue.getName());
        existing.setHabitate(inputValue.getHabitate());

        AnimalEntity entityToSave = animalRepository.save(existing);
        return modelMapper.map(entityToSave, AnimalDto.class);
    }

    public String deleteAnimal(Long animalId){
        boolean exists = animalExists(animalId);
        if(!exists){
            return "Animal Does not exist";
        }else{
            animalRepository.deleteById(animalId);
            return "Animal deleted successfully.";
        }
    }

}
