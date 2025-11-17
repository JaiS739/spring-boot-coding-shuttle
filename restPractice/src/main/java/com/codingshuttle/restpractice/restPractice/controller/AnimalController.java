package com.codingshuttle.restpractice.restPractice.controller;

import com.codingshuttle.restpractice.restPractice.dto.AnimalDto;
import com.codingshuttle.restpractice.restPractice.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
