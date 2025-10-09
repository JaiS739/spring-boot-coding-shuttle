package com.coding_shuttle.rest.rest_api.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employeePractice")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private int age;

    private boolean isActive;
}
