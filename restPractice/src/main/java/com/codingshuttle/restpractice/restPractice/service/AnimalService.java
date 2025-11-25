package com.codingshuttle.restpractice.restPractice.service;

import com.codingshuttle.restpractice.restPractice.dto.AnimalDto;
import com.codingshuttle.restpractice.restPractice.entities.AnimalEntity;
import com.codingshuttle.restpractice.restPractice.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public List<AnimalDto> getAllAnimal(){
        List<AnimalEntity> animalEntities = animalRepository.findAll();

        return animalEntities
                .stream()
                .map(animalEntity -> modelMapper.map(animalEntity, AnimalDto.class))
                .collect(Collectors.toList());
    }

    public Optional<AnimalDto> getAnimalById(Long animalId) {
        return animalRepository.findById(animalId) // this will create the optional here
                .map(entity -> modelMapper.map(entity, AnimalDto.class));
        // not returning orElseThrow because that will be done by the controller layer
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

    public AnimalDto updatePartialAnimalData(Long animalId, Map<String, Object> inputValue) {
        Optional<AnimalEntity> optional = animalRepository.findById(animalId);
        AnimalEntity animalEntity = optional.orElseThrow(
                () -> new RuntimeException("Animal not found")
        );
        inputValue.forEach((fieldName, fieldValue) -> {
            Field field = ReflectionUtils.findField(AnimalEntity.class, fieldName);
            if (field == null) {
                throw new RuntimeException("Invalid field: " + fieldName);
            }
            field.setAccessible(true); // to access the private value
            ReflectionUtils.setField(field, animalEntity, fieldValue);
        });
        return modelMapper.map(animalRepository.save(animalEntity), AnimalDto.class);
    }
}
