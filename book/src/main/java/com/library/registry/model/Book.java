package com.library.registry.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "Field cannot be null")
    private String bookName;
    @NotEmpty(message = "Field cannot be null")
    private String bookAuthor;
    @NotNull
    @Past(message = "Field cannot be in the future")
    private LocalDate releaseDate;
    @NotEmpty(message = "Field cannot be null")
    private String genre; // create a record later
    @NotNull(message = "Field cannot be null")
    private Integer libraryId;

}
