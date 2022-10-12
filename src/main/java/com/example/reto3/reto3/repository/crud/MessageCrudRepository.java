package com.example.reto3.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;

import com.example.reto3.reto3.model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
