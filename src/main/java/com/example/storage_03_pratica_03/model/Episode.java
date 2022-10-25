package com.example.storage_03_pratica_03.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(length = 500)
    String title;

    @Column
    private int number;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column
    private float rating;

    @ManyToOne
    @JoinColumn(name = "id_season")
    @JsonIgnoreProperties(value = "episodes")
    private Season season;


    @ManyToMany
    @JoinTable(
            name = "actor_episodes",
            joinColumns = @JoinColumn(name = "id_epispde", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_actor", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("movies")
    private Set<Actor> actors;
}
