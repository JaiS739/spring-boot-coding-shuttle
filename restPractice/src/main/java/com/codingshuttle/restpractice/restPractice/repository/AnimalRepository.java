package com.codingshuttle.restpractice.restPractice.repository;

import com.codingshuttle.restpractice.restPractice.entities.AnimalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {
}
