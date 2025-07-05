package com.fatih.libraryapi.controller;

import com.fatih.libraryapi.dto.BookDTO;
import com.fatih.libraryapi.model.Book;
import com.fatih.libraryapi.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // POST - Yeni kitap ekle
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody @Valid BookDTO bookDTO) {
        Book savedBook = bookService.addBook(bookDTO);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // GET - Tüm kitapları getir
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // PUT - Kitap güncelle
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody @Valid BookDTO bookDTO) {
        Book updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // DELETE - Kitap sil
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
