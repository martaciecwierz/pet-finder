package com.example.petfinder.model.animal;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnimalType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
