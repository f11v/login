package com.example.CheckUsuario.service.mapper;

import com.example.CheckUsuario.domain.Person;
import com.example.CheckUsuario.service.dto.PersonDto;


public interface PersonMapper {
    PersonDto personToPersonDTO(Person person);
    Person personDTOtoPerson(PersonDto personDTO);
}

