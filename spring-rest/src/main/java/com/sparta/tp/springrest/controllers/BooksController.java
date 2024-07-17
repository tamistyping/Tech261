package com.sparta.tp.springrest.controllers;

import com.sparta.tp.springrest.entities.Book;
import com.sparta.tp.springrest.exceptions.GlobalExceptionHandler;
import com.sparta.tp.springrest.exceptions.ResourceNotFoundException;
import com.sparta.tp.springrest.repositories.AuthorRepository;
import com.sparta.tp.springrest.repositories.BookRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BooksController {

    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BooksController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book, HttpServletRequest request) {
        if (book.getAuthor().getId() == null)
            authorRepository.save(book.getAuthor());
        else if (!authorRepository.existsById(book.getAuthor().getId()))
            throw new ResourceNotFoundException("Author with id: "+ book.getAuthor().getId() + " not found.");

        bookRepository.save(book);
        URI location = URI.create(request.getRequestURL().toString() + '/' + book.getId());
        return ResponseEntity.created(location).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book) {
        if (id != book.getId())
            throw new ResourceNotFoundException( + id + " does not match book id: " + book.getId() + ".");
        else if (book.getAuthor().getId() == null)
            authorRepository.save(book.getAuthor());
        else if (!authorRepository.existsById(book.getAuthor().getId()))
            throw new ResourceNotFoundException("Author with id: " + book.getAuthor().getId() + " not found.");

        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.save(book);
            return ResponseEntity.noContent().build();
        }

        throw new ResourceNotFoundException("Book with id: " + book.getId() + " not found.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        logger.info("Attempting to delete book with id: {}", id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        throw new ResourceNotFoundException("Book with id: " + id + " not found.");
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        }

        throw new ResourceNotFoundException("Book with id: " + id + " not found.");
    }
}
