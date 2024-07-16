package com.sparta.tp.springrest.controllers;

import com.sparta.tp.springrest.entities.Author;
import com.sparta.tp.springrest.repositories.AuthorRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable int id){
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author, HttpServletRequest request){
        Author newAuthor = authorRepository.save(author);

        URI location = URI.create(request.getRequestURL().toString() + "/" + newAuthor.getId());
        return ResponseEntity.created(location).body(newAuthor);
    }
}
