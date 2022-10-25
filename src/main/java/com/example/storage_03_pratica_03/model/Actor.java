package com.example.storage_03_pratica_03.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    @DateTimeFormat(pattern= "dd/mm/yyyy")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @DateTimeFormat(pattern= "dd/mm/yyyy")
    private LocalDateTime updatedAt;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column
    private int rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    @JsonIgnoreProperties("favoriteActors")
    private Movie favoriteMovie;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties("actors")
    private Set<Movie> movies;

    @ManyToMany(mappedBy = "actors")
    @JsonIgnoreProperties("actors")
    private Set<Episode> episodes;
}
