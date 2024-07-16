package com.sparta.tp.springrest.repositories;

import com.sparta.tp.springrest.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}