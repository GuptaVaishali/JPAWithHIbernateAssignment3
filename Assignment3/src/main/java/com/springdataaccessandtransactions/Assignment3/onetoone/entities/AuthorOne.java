package com.springdataaccessandtransactions.Assignment3.onetoone.entities;

import javax.persistence.*;

@Entity
@Table(name = "authorone")
public class AuthorOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;
    private String name;

    @OneToOne(mappedBy = "author")
    private BookOne book;

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

    public BookOne getBook() {
        return book;
    }

    public void setBook(BookOne book) {
        this.book = book;
    }
}
