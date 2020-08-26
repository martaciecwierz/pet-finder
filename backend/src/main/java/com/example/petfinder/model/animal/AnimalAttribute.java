package com.example.petfinder.model.animal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnimalAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "attribute_id", nullable = false)
    private Attribute attribute;
    private String value;
}
