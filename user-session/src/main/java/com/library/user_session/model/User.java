package com.library.user_session.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotEmpty(message = "Field cannot be null")
    private String username;
    @NotEmpty(message = "Field cannot be null")
    private String name;
    @NotEmpty(message = "Field cannot be null")
    private String mail;
    @NotEmpty(message = "Field cannot be null")
    private String password;

}
