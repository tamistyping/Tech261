package com.sparta.tp.springrest.controllers;

import com.sparta.tp.springrest.entities.Author;
import com.sparta.tp.springrest.repositories.AuthorRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Author author){


        if (id != author.getId()) {
            return ResponseEntity.badRequest().build();
        }

        // Find the existing author by ID
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (!optionalAuthor.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        // Update the existing author with the new data
        Author existingAuthor = optionalAuthor.get();
        existingAuthor.setFullName(author.getFullName()); // Update other fields as needed

        // Save the updated author back to the database
        Author updatedAuthor = authorRepository.save(existingAuthor);

        // Return a response with the updated author and HTTP status OK
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Integer id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            authorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
