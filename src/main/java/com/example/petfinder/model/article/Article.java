package com.example.petfinder.model.article;

import com.example.petfinder.model.shelter.Shelter;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "shelter_id")
    private Shelter shelter;
    private Date date;
    private String title;
    private String content;
    private String image;
}
