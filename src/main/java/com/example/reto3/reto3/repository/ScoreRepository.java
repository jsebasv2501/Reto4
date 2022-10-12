package com.example.reto3.reto3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.reto3.reto3.model.Score;
import com.example.reto3.reto3.repository.crud.ScoreCrudRepository;

@Repository
public class ScoreRepository {
    
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>)scoreCrudRepository.findAll();
    }

    public Optional<Score> getIdScore(Integer id){
        return scoreCrudRepository.findById(id);
    }

    public Score save(Score s){
        return scoreCrudRepository.save(s);
    }

    public void borrar(Score s){
        scoreCrudRepository.delete(s);
    }
}
