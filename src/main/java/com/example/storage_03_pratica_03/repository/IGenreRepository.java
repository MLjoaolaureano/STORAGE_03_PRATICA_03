package com.example.storage_03_pratica_03.repository;
import com.example.storage_03_pratica_03.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface IGenreRepository extends CrudRepository<Genre, Integer> {
}
