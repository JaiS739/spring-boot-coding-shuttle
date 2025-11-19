package com.codingshuttle.restpractice.restPractice.service;

import com.codingshuttle.restpractice.restPractice.dto.AnimalDto;
import com.codingshuttle.restpractice.restPractice.entities.AnimalEntity;
import com.codingshuttle.restpractice.restPractice.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
        AnimalEntity animalEntity = modelMapper.map(inputValue, AnimalEntity.class);
        animalEntity.setId(animalId);
        AnimalEntity saveData = animalRepository.save(animalEntity);
        return modelMapper.map(saveData, AnimalDto.class);
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

    public AnimalDto updatePartialAnimalData(Long animalId, Map<String, Object> inputValue){
        boolean exists = animalExists(animalId);
        if(!exists) return null;
        AnimalEntity animalEntity = animalRepository.findById(animalId).get();
        inputValue.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findField(AnimalEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, animalEntity, value);
        });
        return  modelMapper.map(animalRepository.save(animalEntity), AnimalDto.class);
    }

}
