package com.sparta.tp.springjpa;

import com.sparta.tp.springjpa.entities.AuthorEntity;
import com.sparta.tp.springjpa.entities.BookEntity;
import com.sparta.tp.springjpa.repositories.AuthorRepository;
import com.sparta.tp.springjpa.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
import java.util.logging.Logger;

@SpringBootApplication
public class SpringJpaApplication {

    private static final Logger logger = Logger.getLogger(SpringJpaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(AuthorRepository authorRepository, BookRepository bookRepository) {
        return args -> {
            logger.info("CommandLineRunner: Running");

//            AuthorEntity author = new AuthorEntity();
//            author.setFullName("Tamer Parlak");
//            authorRepository.save(author);
//
//            AuthorEntity author2 = new AuthorEntity();
//            author2.setFullName("Michael Morpurgo");
//            authorRepository.save(author2);
//
//            BookEntity book1 = new BookEntity();
//            book1.setTitle("Tam's autobiography");
//            book1.setAuthor(author);
//            bookRepository.save(book1);
//
//            BookEntity book2 = new BookEntity();
//            book2.setTitle("Of Mice and Men");
//            book2.setAuthor(author2);
//            bookRepository.save(book2);
        };
    }

}
