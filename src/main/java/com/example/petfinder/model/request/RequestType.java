package com.example.petfinder.model.request;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class RequestType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
