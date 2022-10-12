package com.example.reto3.reto3.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.reto3.reto3.model.Clientes;
import com.example.reto3.reto3.service.ClientesService;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.POST})
public class ClientesController {
    
    @Autowired
    private ClientesService clientesService;

    @GetMapping("/all")
    public List<Clientes> getClientes(){
        return clientesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Clientes> getCliente(@PathVariable("id") int id){
        return clientesService.getCliente(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes saveClietes(@RequestBody Clientes c){
        return clientesService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes update(@RequestBody Clientes c){
        return clientesService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return clientesService.deleteCliente(id);
    }
}
