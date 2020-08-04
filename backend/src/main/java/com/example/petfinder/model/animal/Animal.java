package com.example.petfinder.model.animal;


import com.example.petfinder.model.shelter.Shelter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    private Shelter shelter;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType animalType;
    private String name;
    private String description;
}
