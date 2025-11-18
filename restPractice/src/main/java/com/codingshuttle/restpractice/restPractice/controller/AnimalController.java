package com.codingshuttle.restpractice.restPractice.controller;

import com.codingshuttle.restpractice.restPractice.dto.AnimalDto;
import com.codingshuttle.restpractice.restPractice.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="/animals")
@RestController
public class AnimalController {
    private final AnimalService animalService;

    public AnimalController (AnimalService animalService){
        this.animalService = animalService;
    }

    @GetMapping()
    public List<AnimalDto> getAllAnimal () {
        return animalService.getAllEmployee();
    }

    @PostMapping()
    public AnimalDto createAnimal(@RequestBody @Valid AnimalDto inputValue){
        return animalService.createAnimal(inputValue);
    }

    @PutMapping(path="/{animalId}")
    public AnimalDto updateAnimalById(@PathVariable Long animalId, @RequestBody AnimalDto inputValue){
        return animalService.updateAnimalById(animalId, inputValue);
    }

}
