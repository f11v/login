package com.example.CheckUsuario.service.mapper.impl;

import com.example.CheckUsuario.domain.Person;
import com.example.CheckUsuario.service.dto.PersonDto;
import com.example.CheckUsuario.service.mapper.PersonMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDto personToPersonDTO(Person person) {
        if (person == null) {
            return null;
        }

        PersonDto personDTO = new PersonDto();
        personDTO.setId(person.getId());
        personDTO.setUsername(person.getUsername());


        return personDTO;
    }

    @Override
    public Person personDTOtoPerson(PersonDto personDTO) {
        if (personDTO == null) {
            return null;
        }

        Person person = new Person();
        person.setId(personDTO.getId());
        person.setUsername(personDTO.getUsername());

        return person;
    }
}
