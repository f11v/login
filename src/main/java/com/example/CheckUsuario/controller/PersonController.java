package com.example.CheckUsuario.controller;

import com.example.CheckUsuario.domain.Person;
import com.example.CheckUsuario.exception.ResourceNotFoundException;
import com.example.CheckUsuario.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public ResponseEntity <?> login(@RequestBody Person person) throws ResourceNotFoundException {
        return new ResponseEntity<>(personService.findByUsernameAndPassword(person), HttpStatus.OK) ;
    }
}
