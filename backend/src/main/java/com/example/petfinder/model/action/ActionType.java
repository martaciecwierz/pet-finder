package com.example.petfinder.model.action;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ActionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int points;
}
