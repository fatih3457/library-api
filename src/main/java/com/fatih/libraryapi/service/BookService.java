package com.fatih.libraryapi.service;

import com.fatih.libraryapi.dto.BookDTO;
import com.fatih.libraryapi.model.Book;
import com.fatih.libraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Kitap ekle
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setPublishedYear(bookDTO.getPublishedYear());
        return bookRepository.save(book);
    }

    // Tüm kitapları getir
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Kitap güncelle
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Kitap bulunamadı"));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setPublishedYear(bookDTO.getPublishedYear());

        return bookRepository.save(book);
    }

    // Kitap sil
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
