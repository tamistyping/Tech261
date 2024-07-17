package com.sparta.tp.springrest.controllers;

import com.sparta.tp.springrest.entities.Author;
import com.sparta.tp.springrest.exceptions.ResourceNotFoundException;
import com.sparta.tp.springrest.repositories.AuthorRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody @Valid Author author, HttpServletRequest request) {
        Author newAuthor = authorRepository.save(author);

        URI location = URI.create(request.getRequestURL().toString() + "/" + newAuthor.getId());
        return ResponseEntity.created(location).body(newAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Author author) {


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

    @GetMapping("/hateoas/authors")
    public CollectionModel<EntityModel<Author>> getAuthorsHateoas() {
        List<EntityModel<Author>> authors = authorRepository.findAll().stream().map(author -> {
            List<Link> bookLinks = author.getBooks().stream().map(book -> WebMvcLinkBuilder.linkTo(methodOn(BooksController.class).getBook(book.getId())).withRel(book.getTitle())).collect(Collectors.toList());
            Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(AuthorsController.class).getAuthor(author.getId())).withSelfRel();
            Link relLink = WebMvcLinkBuilder.linkTo(methodOn(AuthorsController.class).getAuthors()).withRel("author");
            return EntityModel.of(author, selfLink, relLink).add(bookLinks);
        }).collect(Collectors.toList());
        return CollectionModel.of(authors, WebMvcLinkBuilder.linkTo(methodOn(AuthorsController.class).getAuthorsHateoas()).withSelfRel());
    }

    @GetMapping("/{id}")
    public EntityModel<Author> getAuthor(@PathVariable Integer id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null) {
            throw new ResourceNotFoundException("no author with id " + id);
        }
        Link selfLink = WebMvcLinkBuilder.linkTo(methodOn(AuthorsController.class).getAuthor(id)).withSelfRel();

        Link relLink = WebMvcLinkBuilder.linkTo(methodOn(AuthorsController.class).getAuthors()).withRel("author");

        EntityModel<Author> entityModel = EntityModel.of(author, selfLink, relLink);

        return entityModel;
    }
}