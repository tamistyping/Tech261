package com.sparta.tp.springjpa;

import com.sparta.tp.springjpa.repositories.AuthorRepository;
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

    //bean -> authorrepo -> class / command line runner -> class / authorrepo -> object of both -> runner (repo)
    @Bean
    public CommandLineRunner runner(AuthorRepository repository) {
        return args -> {
            logger.info("Hello from CommandLineRunner");
            logger.warning("Here is another line from CommandLineRunner");
            logger.info(repository.findAll().toString());
        };
    }

}
