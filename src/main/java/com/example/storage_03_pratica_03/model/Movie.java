package com.example.storage_03_pratica_03.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(length = 500)
    private String title;

    @Column(precision = 3)
    private float rating;

    @Column
    private int awards;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column
    private int length;

    @ManyToOne
    @JoinColumn(name = "id_genre")
    @JsonIgnoreProperties(value = "movies")
    private Genre genre;

    @OneToMany(mappedBy = "favoriteMovie", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("favoriteMovie")
    private List<Actor> favoriteActors;

    @ManyToMany
    @JoinTable(
            name = "actor_movies",
            joinColumns = @JoinColumn(name = "id_movie", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_actor", referencedColumnName = "id")
    )
    @JsonIgnoreProperties("movies")
    private Set<Actor> actors;

}
