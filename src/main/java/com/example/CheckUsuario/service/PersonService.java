package com.example.CheckUsuario.service;

import com.example.CheckUsuario.domain.Person;
import com.example.CheckUsuario.exception.ResourceNotFoundException;

public interface PersonService {
    Person findByUsernameAndPassword(Person person) throws ResourceNotFoundException;

}
