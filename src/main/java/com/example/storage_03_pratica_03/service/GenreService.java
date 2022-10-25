package com.example.storage_03_pratica_03.service;

import com.example.storage_03_pratica_03.model.Genre;
import com.example.storage_03_pratica_03.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GenreService {

    @Autowired
    IGenreRepository genreRepository;

    public Genre create(Genre genre) {
        Genre actorResponse = this.genreRepository.save(genre);
        return actorResponse;
    }

    public Genre getById(int genreId) {
        return this.genreRepository.findById(genreId).orElse(null);
    }

    public List<Genre> listAll() {
        List<Genre> actorList = new ArrayList<>();
        this.genreRepository.findAll().forEach(actorList::add);
        return actorList;
    }

    public boolean remove(int genreId) {
        this.genreRepository.deleteById(genreId);
        return true;
    }
}
