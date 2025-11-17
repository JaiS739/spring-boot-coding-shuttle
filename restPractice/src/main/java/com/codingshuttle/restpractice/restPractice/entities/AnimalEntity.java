package com.codingshuttle.restpractice.restPractice.entities;
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

@Column(name="type")
    private String name;

@Column(name="habitate")
    private String habitate;

@Column(name="isDomestic")
    private boolean isDomestic;

@Column(name="secret")
    private String secret;

}
