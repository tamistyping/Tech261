package com.sparta.tp.springrest.repositories;

import com.sparta.tp.springrest.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}