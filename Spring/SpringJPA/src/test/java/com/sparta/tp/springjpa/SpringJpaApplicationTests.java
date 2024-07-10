package com.sparta.tp.springjpa;

import com.sparta.tp.springjpa.repositories.AuthorRepository;
import com.sparta.tp.springjpa.entities.AuthorEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    @DisplayName("Check that I can see all Authors")
    void checkThatICanSeeAllAuthors() {
        List<AuthorEntity> authors = authorRepository.findAll();
        authors.forEach(System.out::println);
    }

    @Test
    @DisplayName("Check that I can find an author by their ID")
    void checkThatICanFindAnAuthorByTheirID() {
        Optional<AuthorEntity> author = authorRepository.findById(1);
        author.ifPresent(System.out::println);
    }

    @Test
    @DisplayName("Check that I can update an author's name")
    void checkThatICanUpdateAnAuthorsName() {
        AuthorEntity author = new AuthorEntity();
        author.setFullName("Paul Smith");
        author = authorRepository.save(author);

        int rowsUpdated = authorRepository.updateAuthorName(1, "Simon Parker");
        if (rowsUpdated > 0) {
            System.out.println("Author name updated successfully.");
        } else {
            System.out.println("Failed to update author name.");
        }
    }

    @Test
    @DisplayName("Check that I can delete an author by their ID")
    void checkThatICanDeleteAnAuthorByTheirID() {

        AuthorEntity author = new AuthorEntity();
        author.setFullName("Paul Smith");
        author = authorRepository.save(author);

        Integer authorId = author.getId();

        authorRepository.deleteById(authorId);

        assertFalse(authorRepository.findById(authorId).isPresent());
    }

    @Test
    @DisplayName("Check that I can find all authors with only one book")
    void checkThatICanFindAllAuthorsWithOnlyOneBook() {
        List<AuthorEntity> authorsWithOneBook = authorRepository.findAuthorsWithOneBook();
        authorsWithOneBook.forEach(System.out::println);

        int expectedNumberOfAuthors = 2;
        assertEquals(expectedNumberOfAuthors, authorsWithOneBook.size());
    }
}
