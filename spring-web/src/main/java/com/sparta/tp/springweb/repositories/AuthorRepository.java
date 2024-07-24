package com.sparta.tp.springweb.repositories;

import com.sparta.tp.springweb.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}