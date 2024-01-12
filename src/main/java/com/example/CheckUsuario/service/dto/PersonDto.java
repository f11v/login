package com.example.CheckUsuario.service.dto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    @Id
    private UUID id;
    private String username;
    private String password;
}
