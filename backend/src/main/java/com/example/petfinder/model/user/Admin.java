package com.example.petfinder.model.user;


import com.example.petfinder.model.shelter.Shelter;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    private Shelter shelter;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private int rights;
}
