package com.example.CheckUsuario.service.impl;

import com.example.CheckUsuario.domain.Person;
import com.example.CheckUsuario.exception.ResourceNotFoundException;
import com.example.CheckUsuario.repository.PersonRepository;
import com.example.CheckUsuario.service.PersonService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person findByUsernameAndPassword(Person person) throws ResourceNotFoundException {
        if (StringUtils.isBlank(person.getUsername()) || StringUtils.isBlank(person.getPassword())) {
            throw new IllegalArgumentException("Username or password cannot be empty");
        }

        if (Objects.isNull(personRepository.findByUsernameAndPassword(person.getUsername(), person.getPassword()))) {
            throw new ResourceNotFoundException("Person not found");
        }
        return person;
    }

}



