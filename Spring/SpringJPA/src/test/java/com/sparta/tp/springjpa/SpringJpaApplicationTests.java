package com.sparta.tp.springjpa;

import com.sparta.tp.springjpa.repositories.AuthorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJpaApplicationTests {

    @Autowired
    AuthorRepository repository;

    @Test
    @DisplayName("check that I can see all Authors")
    void checkThatICanSeeAllAuthors() {
        System.out.println(repository.findAll());
    }

}
