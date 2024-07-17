package com.sparta.tp.springrest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Authors", schema = "Library")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Author {
    @Id
    @Column(name = "author_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 40)
    @Column(name = "full_name", length = 40)
    private String fullName;

    @OneToMany(mappedBy = "author",
    fetch=FetchType.LAZY,
    cascade = CascadeType.ALL)
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

}