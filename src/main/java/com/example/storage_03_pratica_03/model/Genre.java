package com.example.storage_03_pratica_03.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Genre {
    @Id
    private int id;

    @Column(name = "created_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDateTime updatedAt;

    @Column(length = 100)
    String name;

    @Column
    private int ranking;

    @Column
    private boolean active;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("genre")
    private List<Movie> movies;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("genre")
    private List<Serie> series;


}
