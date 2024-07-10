package com.sparta.tp.springjpa.service;

import com.sparta.tp.springjpa.entities.AuthorEntity;
import com.sparta.tp.springjpa.repositories.AuthorRepository;
import com.sparta.tp.springjpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<AuthorEntity> findAuthorsWithOneBook() {
        return authorRepository.findAuthorsWithOneBook();
    }

}
