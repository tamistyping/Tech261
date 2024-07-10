package com.sparta.tp.springjpa.repositories;

import com.sparta.tp.springjpa.entities.AuthorEntity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {

    @Query("SELECT a FROM AuthorEntity a WHERE (SELECT COUNT(b) FROM BookEntity b WHERE b.author = a) = 1")
    List<AuthorEntity> findAuthorsWithOneBook();

    @Query(value = "select * from library.authors where authors.full_name like %?1%", nativeQuery = true)
    Optional<AuthorEntity> findAuthorByName(String name);

    void deleteAll();

    Optional<AuthorEntity> findAuthorById(int id);

    @Modifying
    @Transactional
    @Query(value = "update library.authors set full_name = ?2 where author_id = ?1", nativeQuery = true)
    int updateAuthorName(Integer id, String newName);

    @Modifying
    @Transactional
    @Query(value = "delete from Authors where author_id = ?1", nativeQuery = true)
    void deleteById(Integer id);

}
