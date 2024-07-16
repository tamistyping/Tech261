package com.sparta.tp.springrest.controllers;

import com.sparta.tp.springrest.entities.Book;
import com.sparta.tp.springrest.exceptions.ResourceNotFoundException;
import com.sparta.tp.springrest.repositories.AuthorRepository;
import com.sparta.tp.springrest.repositories.BookRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {
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
}
