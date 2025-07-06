package com.fatih.libraryapi.service;

import com.fatih.libraryapi.dto.BookDTO;
import com.fatih.libraryapi.model.Book;
import com.fatih.libraryapi.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Yeni kitap ekle
    public Book addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setCategory(bookDTO.getCategory());
        book.setPublishedYear(bookDTO.getPublishedYear());
        return bookRepository.save(book);
    }

    // Sayfalı ve filtreli kitapları getir
    public Page<Book> getBooks(int page, int size, String title) {
        PageRequest pageRequest = PageRequest.of(page, size);
        if (title != null && !title.isEmpty()) {
            return bookRepository.findByTitleContainingIgnoreCase(title, pageRequest);
        }
        return bookRepository.findAll(pageRequest);
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
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Kitap bulunamadı");
        }
        bookRepository.deleteById(id);
    }
}