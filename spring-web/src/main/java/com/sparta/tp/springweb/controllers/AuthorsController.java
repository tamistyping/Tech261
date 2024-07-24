package com.sparta.tp.springweb.controllers;

import com.sparta.tp.springweb.entities.Author;
import com.sparta.tp.springweb.repositories.AuthorRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorsController {

    private final AuthorRepository authorRepository;

    public AuthorsController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }

    @GetMapping("/authors/create")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/create";
    }

    @PostMapping("/authors/create")
    public String createAuthor(@Valid @ModelAttribute("author") Author author, Errors errors) {
        if (errors.hasErrors()){
            return "authors/create";
        }

        authorRepository.save(author);
        return "redirect:/authors";
    }
}