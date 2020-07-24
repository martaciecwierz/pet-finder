package com.example.petfinder.model.action;

import com.example.petfinder.model.request.Request;
import com.example.petfinder.model.shelter.Shelter;
import com.example.petfinder.model.user.User;
import com.example.petfinder.model.animal.Animal;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Action {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    private Shelter shelter;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ActionType actionType;
    private int userRate;
    private int shelterRate;
    private int quantity;
    private Date date;
    private boolean isDone;
}
