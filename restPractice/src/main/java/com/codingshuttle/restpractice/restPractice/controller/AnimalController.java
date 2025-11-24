package com.codingshuttle.restpractice.restPractice.controller;

import com.codingshuttle.restpractice.restPractice.dto.AnimalDto;
import com.codingshuttle.restpractice.restPractice.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping(path="/animals")
@RestController
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController (AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping()
    public List<AnimalDto> getAllAnimal () {
        return animalService.getAllAnimal();
    }

    @GetMapping(path="/{animalId}")
    public AnimalDto getAnimalById(@PathVariable Long animalId){
        return animalService.getAnimalById(animalId);
    }

    @PostMapping()
    public AnimalDto createAnimal(@RequestBody @Valid AnimalDto inputValue){
        return animalService.createAnimal(inputValue);
    }

    @PutMapping(path="/{animalId}")
    public AnimalDto updateAnimalById(@PathVariable Long animalId, @RequestBody AnimalDto inputValue){
        return animalService.updateAnimalById(animalId, inputValue);
    }

    @DeleteMapping(path="/{animalId}")
    public String deleteAnimal (@PathVariable Long animalId) {
        return animalService.deleteAnimal(animalId);
    }

    @PatchMapping(path="/{animalId}")
    public AnimalDto updatePartialAnimalData(@PathVariable Long animalId, @RequestBody Map<String, Object> inputValue){
        return animalService.updatePartialAnimalData(animalId, inputValue);
    }

}
