package com.sparta.tp.springjpa;

import com.sparta.tp.springjpa.repositories.AuthorRepository;
import com.sparta.tp.springjpa.repositories.BookRepository;
import com.sparta.tp.springjpa.entities.AuthorEntity;
import com.sparta.tp.springjpa.entities.BookEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;

    @Test
    @DisplayName("check that I can see all Authors")
    void checkThatICanSeeAllAuthors() {
        System.out.println(authorRepository.findAll());
    }

    @Test
    @DisplayName("Check that I can find an author by their ID")
    void checkThatICanFindAnAuthorByTheirID() {
        System.out.println(authorRepository.findById(1));
    }

    @Test
    @DisplayName("Check that I can find authors by their names")
    void checkThatICanFindAuthorsByTheirNames() {
        List<AuthorEntity> authors = new ArrayList<>(authorRepository.findAllByFullName("Manish"));
        for (AuthorEntity author : authors) {
            System.out.println(author.toString());
        }
    }

    @Test
    @DisplayName("Check that I can see all books")
    void checkThatICanSeeAllBooks() {
        List<BookEntity> books = new ArrayList<>(bookRepository.findAll());
        for (BookEntity book : books) {
            System.out.println(book.toString());
        }
    }

}
