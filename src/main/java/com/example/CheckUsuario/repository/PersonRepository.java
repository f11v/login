package com.example.CheckUsuario.repository;
import com.example.CheckUsuario.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findByUsernameAndPassword(String username, String password);
}
