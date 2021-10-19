package com.springdataaccessandtransactions.Assignment3.manytomany.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authormany")
public class AuthorMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "authorid", referencedColumnName = "author_id"),
    inverseJoinColumns = @JoinColumn(name = "bookid", referencedColumnName = "book_id"))
    private List<BookMany> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BookMany> getBooks() {
        return books;
    }

    public void setBooks(List<BookMany> books) {
        this.books = books;
    }
}
