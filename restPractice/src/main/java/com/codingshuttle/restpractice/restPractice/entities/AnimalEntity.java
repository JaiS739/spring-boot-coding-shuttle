package com.codingshuttle.restpractice.restPractice.entities;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name="AnimalTable")
@Getter
@Setter
public class AnimalEntity {

 @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

@Column(name="name")
    private String name;

@Column(name="habitate")
    private String habitate;

@JsonProperty("isDomestic")
@Column(name="isDomestic")
    private Boolean isDomestic;

@Column(name="secret")
    private String secret;

}
