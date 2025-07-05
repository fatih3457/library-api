package com.fatih.libraryapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookDTO {

    @NotBlank(message = "Kitap başlığı boş olamaz")
    private String title;

    @NotBlank(message = "Yazar adı boş olamaz")
    private String author;

    private String category;

    @Min(value = 0, message = "Yayın yılı negatif olamaz")
    private Integer publishedYear;

    // Getter ve Setter'lar

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
}
