package com.sparta.tp.springjpa.utilities;

import com.sparta.tp.springjpa.entities.AuthorEntity;
import com.sparta.tp.springjpa.repositories.AuthorRepository;

public class AuthorAdder {
    private final AuthorRepository authorRepo;

    public AuthorAdder(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public void addAuthor(String fullName){
        AuthorEntity author = new AuthorEntity();
        author.setFullName(fullName);
        authorRepo.save(author);
    }
}
