package com.example.petfinder.model.request;

import com.example.petfinder.model.shelter.Shelter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    private Shelter shelter;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private RequestType requestType;
    private int quantity;
}
