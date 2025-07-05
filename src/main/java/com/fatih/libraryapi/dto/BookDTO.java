package com.fatih.libraryapi.dto;

import lombok.Data;

@Data
public class BookDTO {

    private String title;
    private String author;
    private String category;
    private Integer publishedYear;
}
