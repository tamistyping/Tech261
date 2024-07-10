package com.sparta.tp.springjpa.repositories;

import com.sparta.tp.springjpa.entities.AuthorEntity;
import com.sparta.tp.springjpa.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer>{
    List<BookEntity> findByTitle(String name);
    List<BookEntity> findAllByAuthor(Optional<AuthorEntity> authorEntity);
}
