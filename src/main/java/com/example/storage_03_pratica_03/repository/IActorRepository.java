package com.example.storage_03_pratica_03.repository;

import com.example.storage_03_pratica_03.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface IActorRepository extends CrudRepository<Actor, Integer> {
}
