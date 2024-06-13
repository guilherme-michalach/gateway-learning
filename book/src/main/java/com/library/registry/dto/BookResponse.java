package com.library.registry.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

    private Integer id;
    private String bookName;
    private String bookAuthor;
    private LocalDate releaseDate;
    private String genre; // create a record later
    private Library library;

}
