package com.module4.production_ready_feature.production_ready_feature.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Posts")
public class PostEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String title;

    private String Description;
}
