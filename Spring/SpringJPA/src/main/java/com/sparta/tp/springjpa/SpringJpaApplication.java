package com.sparta.tp.springjpa;

import com.sparta.tp.springjpa.repositories.AuthorRepository;
import com.sparta.tp.springjpa.utilities.AuthorAdder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class SpringJpaApplication {

    private static final Logger logger = Logger.getLogger(SpringJpaApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(AuthorRepository repository) {
        return args -> {
            logger.info("Hello from CommandLineRunner");
            logger.warning("Here is another line from CommandLineRunner");

            AuthorAdder authorAdder = new AuthorAdder(repository);

            authorAdder.addAuthor("Roald Dahl");
            authorAdder.addAuthor("Michael Morpurgo");
            authorAdder.addAuthor("Bob");
            logger.info("Author(s) successfully added.");
        };
    }

}
