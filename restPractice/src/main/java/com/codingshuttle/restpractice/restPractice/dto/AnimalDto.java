package com.codingshuttle.restpractice.restPractice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AnimalDto {
    private Long id;

    @NotNull(message = "name can not be null")
    private String name;

    @NotNull (message = "Habitate can not be null")
    private String habitate;

    @NotNull (message = "Please tick if the animal is domestic")
    private boolean isDomestic;

    private String secret;

}
