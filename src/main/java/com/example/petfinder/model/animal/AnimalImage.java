package com.example.petfinder.model.animal;


import com.example.petfinder.model.animal.Animal;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AnimalImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    private String image;
}
