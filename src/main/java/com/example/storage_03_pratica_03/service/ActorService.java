package com.example.storage_03_pratica_03.service;

import com.example.storage_03_pratica_03.model.Actor;
import com.example.storage_03_pratica_03.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    IActorRepository actorRepository;

    public Actor create(Actor actor) {
        Actor actorResponse = this.actorRepository.save(actor);
        return actorResponse;
    }

    public Actor getById(int actorId) {
        return this.actorRepository.findById(actorId).orElse(null);
    }

    public List<Actor> listAll() {
        List<Actor> actorList = new ArrayList<>();
        this.actorRepository.findAll().forEach(actorList::add);
        return actorList;
    }

    public boolean remove(int actorId) {
        this.actorRepository.deleteById(actorId);
        return true;
    }
}
