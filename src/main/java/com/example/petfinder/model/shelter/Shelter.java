package com.example.petfinder.model.shelter;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Shelter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String addressStreet;
    private String addressBuilding;
    private String addressCity;
    private String addressPostCode;
    private String email;
    private String phone;
    private String description;
}
